package com.turing_machine.views;

import java.util.ArrayList;
import com.turing_machine.listeners.PlayerTestedCodesLineActionListener;
import com.turing_machine.started_game.StartedGamePlayerTestedCodesLine;

public class StartedGamePlayerTestedCodesLinePanel implements Displayable {

	private ArrayList<PlayerTestedCodesLineActionListener> listeners;

	private StartedGamePlayerTestedCodesLine line;

	public StartedGamePlayerTestedCodeLinePanel(StartedGamePlayerTestedCodesLine line) {

	}

	public void whenActionLaunched(PlayerTestedCodesLineActionListener listener) {

	}

}
