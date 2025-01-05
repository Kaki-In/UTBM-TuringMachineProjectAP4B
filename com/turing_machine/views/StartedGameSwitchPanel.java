package com.turing_machine.views;

import com.turing_machine.started_game.StartedGame;
import com.turing_machine.started_game.StartedGamePlayer;
import com.turing_machine.started_game.StartedGamePlayersList;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartedGameSwitchPanel extends Displayable {

	private String opened_player;

	private StartedGame game;

	private StartedGamePublicPanel players_selection;

	private ArrayList<StartedGamePlayerNotesPanel> players_notes;

	private JPanel panel;

	private GridBagConstraints displayed_constraints;

	public StartedGameSwitchPanel(StartedGame game) {
		this.opened_player = null;
		this.game = game;

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		this.displayed_constraints = new GridBagConstraints();
		displayed_constraints.gridx = 0;
		displayed_constraints.gridy = 0;
		displayed_constraints.fill = GridBagConstraints.BOTH;
		displayed_constraints.weightx = 1;
		displayed_constraints.weighty = 1;

		this.players_selection = new StartedGamePublicPanel(game);
		this.panel.add(players_selection.getWidget(), displayed_constraints);

		this.players_notes = new ArrayList<>();

		StartedGamePlayersList players = game.getPlayersList();

		ArrayList<String> names = players.getPlayersNames();

		for (int i=0; i < names.size(); ++i)
		{
			String player_name = names.get(i);
			StartedGamePlayer player = players.getPlayerByName(player_name);

			StartedGamePlayerNotesPanel panel = new StartedGamePlayerNotesPanel(player);

			this.players_notes.add(panel);

			panel.whenShouldReload(() -> reloadParent());
			panel.whenCloseAction(() -> {
				this.opened_player = null;
				reloadParent();
			});
		}

		this.players_selection.whenShouldReload(() -> {reloadParent();});
		this.players_selection.whenPlayerAskedToEnter((player_name) -> {
			int result = JOptionPane.showConfirmDialog(this.panel, "Assurez-vous que personne ne peut voir votre feuille de notes", "Vous allez voir vos notes personnelles", JOptionPane.PLAIN_MESSAGE);

			if (result == JOptionPane.OK_OPTION)
			{
				this.opened_player = player_name;
			}

			reloadParent();
		});

		this.panel.setPreferredSize(new Dimension(1200, 700));
	}

	public Displayable getDisplayedPanel()
	{
		if (this.opened_player == null)
		{
			return this.players_selection;
		} else {
			for (StartedGamePlayerNotesPanel panel: this.players_notes)
			{
				if (panel.getPlayer().getName().equals(opened_player) && !panel.getPlayer().isEliminated())
				{
					return panel;
				}
			}
		}

		// choix par défaut, si quelque chose n'a pas marché
		this.opened_player = null;
		return this.players_selection;
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		this.panel.removeAll();

		Displayable displayed_panel = this.getDisplayedPanel();
		this.panel.add(displayed_panel.getWidget(), this.displayed_constraints);
		displayed_panel.refresh();
		
		this.panel.revalidate();
		this.panel.repaint();
	}

}
