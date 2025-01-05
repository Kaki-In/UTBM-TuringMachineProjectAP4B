package com.turing_machine.views;

import com.turing_machine.listeners.ObjectSelectionListener;
import com.turing_machine.started_game.StartedGame;
import com.turing_machine.started_game.StartedGamePlayer;
import com.turing_machine.started_game.StartedGamePlayersList;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartedGamePublicPanel extends Displayable {

	private ArrayList<ObjectSelectionListener<String>> listeners;

	private StartedGame game;

	private ArrayList<StartedGameEnterPlayerPanel> players_view;

	private StartedGameMachinePanel machine_panel;

	private JPanel panel;

	private final JButton endRoundButton;

	public StartedGamePublicPanel(StartedGame game) {
		this.listeners = new ArrayList<>();
		this.game = game;

		StartedGamePlayersList players = game.getPlayersList();

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		GridBagConstraints titleConstraints = new GridBagConstraints();
		titleConstraints.gridx = 1;
		titleConstraints.gridy = 0;
		titleConstraints.weightx = 1;
		titleConstraints.anchor = GridBagConstraints.CENTER;

		JLabel title_label = new JLabel("Joueurs");
		title_label.setFont(Displayable.getFont(20).deriveFont(Font.BOLD));
		title_label.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 50));
		this.panel.add(title_label, titleConstraints);

		this.players_view = new ArrayList<>();

		ArrayList<String> names = players.getPlayersNames();
		for (int i=0; i < names.size(); ++i)
		{
			String player_name = names.get(i);

			StartedGamePlayer player = players.getPlayerByName(player_name);

			GridBagConstraints playerConstraints = new GridBagConstraints();
			playerConstraints.gridx = 1;
			playerConstraints.gridy = i + 1;
			playerConstraints.weightx = 1;
			playerConstraints.weighty = 0;
			playerConstraints.fill = GridBagConstraints.HORIZONTAL;

			StartedGameEnterPlayerPanel player_panel = new StartedGameEnterPlayerPanel(player);

			this.players_view.add(player_panel);
			this.panel.add(player_panel.getWidget(), playerConstraints);

			player_panel.whenShouldReload(() -> reloadParent());

			player_panel.whenPlayerAskedToEnter(() -> {
				for (ObjectSelectionListener<String> listener: this.listeners)
				{
					listener.onObjectSelected(player_name);
				}
			});
		}

		GridBagConstraints spaceConstraints = new GridBagConstraints();
		spaceConstraints.gridx = 1;
		spaceConstraints.gridy = names.size() + 1;
		spaceConstraints.weightx = 1;
		spaceConstraints.weighty = 1;
		spaceConstraints.fill = GridBagConstraints.HORIZONTAL;

		this.panel.add(new JPanel(), spaceConstraints);

		GridBagConstraints machineConstraints = new GridBagConstraints();
		machineConstraints.gridx = 0;
		machineConstraints.gridy = 0;
		machineConstraints.gridwidth = 1;
		machineConstraints.gridheight = names.size() + 2;
		machineConstraints.weightx = 1;
		machineConstraints.weighty = 1;

		this.machine_panel = new StartedGameMachinePanel(game.getState().getMachine());
		this.panel.add(this.machine_panel.getWidget(), machineConstraints);

		GridBagConstraints endConstraints = new GridBagConstraints();
		endConstraints.gridx = 0;
		endConstraints.gridy = names.size() + 3;
		endConstraints.gridwidth = 2;
		endConstraints.fill = GridBagConstraints.HORIZONTAL;

		this.endRoundButton = new JButton("Fin de la manche");

		this.panel.add(this.endRoundButton, endConstraints);

		this.machine_panel.whenShouldReload(() -> reloadParent());

		this.endRoundButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				int result = JOptionPane.showConfirmDialog(panel, "Êtes-vous sûr de vous passer à la prochaine manche?", "Passer à la prochaine manche", JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION)
				{
					game.getState().endRound();
				}
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

		game.getState().whenRoundChanged((round_id) -> {
			reloadParent();

			if (game.getPlayersList().getAlivePlayers().isEmpty()) return;

			JOptionPane.showMessageDialog(panel, "C'est le commencement de la manche numéro " + (round_id + 1), "Nouvelle manche", JOptionPane.OK_OPTION);
		});
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		for (StartedGameEnterPlayerPanel panel: this.players_view)
		{
			panel.refresh();
		}

		this.machine_panel.refresh();
	}

	public void whenPlayerAskedToEnter(ObjectSelectionListener<String> listener) {
		this.listeners.add(listener);
	}

}
