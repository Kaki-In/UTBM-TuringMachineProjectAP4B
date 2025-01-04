package com.turing_machine.views;

import com.turing_machine.started_game.StartedGamePlayersList;
import javax.swing.JComponent;
import java.util.ArrayList;

public class StartedGamePlayersPanel extends Displayable {

	private String opened_player;

	private StartedGamePlayersList players;

	private StartedGamePlayersListPanel players_selection;

	private ArrayList<StartedGamePlayerNotesPanel> players_notes;

	public StartedGamePlayersPanel(StartedGamePlayersList players) {

	}

	@Override
	public JComponent getWidget()
	{
		return null;
	}

	@Override
	public void refresh()
	{
	}

}
