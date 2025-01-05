package com.turing_machine.views;

import com.turing_machine.listeners.ObjectSelectionListener;
import com.turing_machine.started_game.StartedGamePlayer;
import com.turing_machine.started_game.StartedGamePlayersList;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartedGamePlayersListPanel extends Displayable {

	private ArrayList<ObjectSelectionListener<String>> listeners;

	private StartedGamePlayersList players;

	private ArrayList<StartedGameEnterPlayerPanel> players_view;

	private JPanel panel;

	public StartedGamePlayersListPanel(StartedGamePlayersList players) {
		this.listeners = new ArrayList<>();
		this.players = players;

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		GridBagConstraints titleConstraints = new GridBagConstraints();
		titleConstraints.gridx = 0;
		titleConstraints.gridy = 0;

		JLabel title_label = new JLabel("Joueurs");
		title_label.setFont(Displayable.getFont(20).deriveFont(Font.BOLD));
		title_label.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
		this.panel.add(title_label, titleConstraints);

		this.players_view = new ArrayList<>();

		ArrayList<String> names = this.players.getPlayersNames();
		for (int i=0; i < names.size(); ++i)
		{
			String player_name = names.get(i);

			StartedGamePlayer player = this.players.getPlayerByName(player_name);

			GridBagConstraints playerConstraints = new GridBagConstraints();
			playerConstraints.gridx = 0;
			playerConstraints.gridy = i + 1;

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
	}

	public void whenPlayerAskedToEnter(ObjectSelectionListener<String> listener) {
		this.listeners.add(listener);
	}

}
