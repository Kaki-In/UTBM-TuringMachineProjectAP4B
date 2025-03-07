package com.turing_machine.views;

import com.turing_machine.configuration.PlayerConfiguration;
import com.turing_machine.configuration.PlayersConfiguration;
import com.turing_machine.listeners.ObjectsListChangeListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayersConfigurationPanel extends Displayable {

	private final PlayersConfiguration configuration;

	private final ArrayList<ConfiguratingPlayerPanel> players;

	private int last_refresh_length;

	private final JPanel panel;
	private final JButton add_button;

	public PlayersConfigurationPanel(PlayersConfiguration configuration) {
		this.configuration = configuration;

		this.players = new ArrayList<>();
		this.last_refresh_length = configuration.getPlayers().size();


		for (PlayerConfiguration player: configuration.getPlayers())
		{
			ConfiguratingPlayerPanel player_panel = new ConfiguratingPlayerPanel(player);
			player_panel.whenShouldReload(() -> reloadParent());
			this.players.add(player_panel);
		}

		configuration.whenPlayersListModified(new ObjectsListChangeListener<PlayerConfiguration>() {
			@Override
			public void onObjectAdded(PlayerConfiguration object, ArrayList<PlayerConfiguration> new_list) {
				ConfiguratingPlayerPanel player_panel = new ConfiguratingPlayerPanel(object);
				player_panel.whenShouldReload(() -> reloadParent());
				players.add(player_panel);

				reloadParent();
			}

			@Override
			public void onObjectDeleted(PlayerConfiguration object, ArrayList<PlayerConfiguration> new_list) {
				players.removeIf(player_panel -> player_panel.getConfiguration() == object);
				reloadParent();
			}
		});

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		this.add_button = new JButton("Ajouter un joueur");
		this.add_button.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				configuration.addPlayer();
			}

			@Override
			public void mousePressed(MouseEvent me) {}

			@Override
			public void mouseReleased(MouseEvent me) {}

			@Override
			public void mouseEntered(MouseEvent me) {}

			@Override
			public void mouseExited(MouseEvent me) {}
		});

		preparePanel();
	}

	public void preparePanel()
	{
		this.panel.removeAll();
		this.panel.repaint();

		GridBagConstraints titleLabelConstraint = new GridBagConstraints();
		titleLabelConstraint.gridx = 0;
		titleLabelConstraint.gridy = 0;
		titleLabelConstraint.gridwidth = 2;
		titleLabelConstraint.gridheight = 1;
		titleLabelConstraint.fill = GridBagConstraints.VERTICAL;
		titleLabelConstraint.anchor = GridBagConstraints.CENTER;
		titleLabelConstraint.weighty = 1;

		JLabel title_label = new JLabel("Joueurs");
		title_label.setFont(Displayable.getFont(20));
		this.panel.add(title_label, titleLabelConstraint);

		for (int player_id = 0; player_id < this.players.size(); ++player_id) {
			ConfiguratingPlayerPanel player = this.players.get(player_id);
			GridBagConstraints playerConstraint = new GridBagConstraints();
			playerConstraint.gridx = 0;
			playerConstraint.gridy = player_id + 1;
			playerConstraint.fill = GridBagConstraints.HORIZONTAL;
			playerConstraint.weightx = 1;

			this.panel.add(player.getWidget(), playerConstraint);

			GridBagConstraints deleteConstraint = new GridBagConstraints();
			deleteConstraint.gridx = 1;
			deleteConstraint.gridy = player_id + 1;

			JButton button = new JButton("Supprimer");
			this.panel.add(button, deleteConstraint);

			final int this_player_id = player_id;

			button.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent me) {
					configuration.removePlayer(this_player_id);
				}

				@Override
				public void mousePressed(MouseEvent me) {}

				@Override
				public void mouseReleased(MouseEvent me) {}

				@Override
				public void mouseEntered(MouseEvent me) {}

				@Override
				public void mouseExited(MouseEvent me) {}

			});
		}

		GridBagConstraints addbuttonConstraint = new GridBagConstraints();
		addbuttonConstraint.gridx = 0;
		addbuttonConstraint.gridy = this.players.size() + 1;
		addbuttonConstraint.gridwidth = 2;
		addbuttonConstraint.gridheight = 1;
		addbuttonConstraint.fill = GridBagConstraints.VERTICAL;
		addbuttonConstraint.anchor = GridBagConstraints.CENTER;
		addbuttonConstraint.weighty = 1;

		this.panel.add(this.add_button, addbuttonConstraint);
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		if (this.last_refresh_length != configuration.getPlayers().size())
		{
			preparePanel();
			this.last_refresh_length = configuration.getPlayers().size();
		}

		for (ConfiguratingPlayerPanel player_panel: this.players)
		{
			player_panel.refresh();
		}
	}

}
