package com.turing_machine.views;

import com.turing_machine.listeners.PlayerTestedCodesActionListener;
import com.turing_machine.started_game.StartedGamePlayerTestedCodesGrid;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGamePlayerTestedCodesPanel implements Displayable {

	private ArrayList<PlayerTestedCodesActionListener> listeners;

	private StartedGamePlayerTestedCodesGrid codes_grid;

	private ArrayList<StartedGamePlayerTestedCodeLinePanel> lines;

	public StartedGamePlayerTestedCodesPanel(StartedGamePlayerTestedCodesGrid codes_grid) {

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

	public void whenActionLaunched(PlayerTestedCodesActionListener listener) {

	}

}
