package com.turing_machine.views;

import com.turing_machine.listeners.ObjectSelectionListener;
import com.turing_machine.started_game.StartedGamePlayersList;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGamePlayersListPanel implements Displayable {

	private ArrayList<ObjectSelectionListener<String>> listeners;

	private StartedGamePlayersList players;

	private ArrayList<StartedGameEnterPlayerPanel> players_view;

	public StartedGamePlayersListPanel(StartedGamePlayersList players) {

	}

	@Override
	public Component getWidget()
	{
		return null;
	}

	@Override
	public void refresh()
	{
	}

	public void whenPlayerAskedToEnter(ObjectSelectionListener<String> listener) {

	}

}
