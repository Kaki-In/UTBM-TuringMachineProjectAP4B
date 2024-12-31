package com.turing_machine.views;

import java.util.ArrayList;
import com.turing_machine.listeners.PlayerTestedCodesLineActionListener;
import com.turing_machine.started_game.StartedGamePlayerTestedCodesLine;
import java.awt.Component;

public class StartedGamePlayerTestedCodeLinePanel implements Displayable {

	private ArrayList<PlayerTestedCodesLineActionListener> listeners;

	private StartedGamePlayerTestedCodesLine line;

	public StartedGamePlayerTestedCodeLinePanel(StartedGamePlayerTestedCodesLine line) {

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

	public void whenActionLaunched(PlayerTestedCodesLineActionListener listener) {

	}

}
