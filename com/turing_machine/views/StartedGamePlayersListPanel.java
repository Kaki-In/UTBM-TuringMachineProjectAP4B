package com.turing_machine.views;

import com.turing_machine.listeners.ObjectSelectionListener;
import com.turing_machine.started_game.StartedGamePlayersList;
import javax.swing.JComponent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class StartedGamePlayersListPanel extends Displayable {

	private ArrayList<ObjectSelectionListener<String>> listeners;

	private StartedGamePlayersList players;

	private ArrayList<StartedGameEnterPlayerPanel> players_view;

	private JPanel panel;

	public StartedGamePlayersListPanel(StartedGamePlayersList players) {
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

	public void whenPlayerAskedToEnter(ObjectSelectionListener<String> listener) {

	}

}
