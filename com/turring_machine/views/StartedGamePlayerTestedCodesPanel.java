package com.turring_machine.views;

import java.util.ArrayList;
import com.turring_machine.listeners.PlayerTestedCodesActionListener;
import com.turring_machine.started_game.StartedGamePlayerTestedCodesGrid;

public class StartedGamePlayerTestedCodesPanel implements Displayable {

	private ArrayList<PlayerTestedCodesActionListener> listeners;

	private StartedGamePlayerTestedCodesGrid codes_grid;

	private ArrayList<StartedGamePlayerTestedCodesLinePanel> lines;

	public StartedGamePlayerTestedCodesPanel(StartedGamePlayerTestedCodesGrid codes_grid) {

	}

	public void whenActionLaunched(PlayerTestedCodesActionListener listener) {

	}

}
