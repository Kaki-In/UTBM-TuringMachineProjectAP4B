package com.turring_machine.views;

import java.util.ArrayList;
import com.turring_machine.listeners.PlayerNumbersGridActionListener;
import com.turring_machine.started_game.StartedGamePlayerNumbersGrid;

public class StartedGamePlayerNumbersGridPanel implements Displayable {

	private ArrayList<PlayerNumbersGridActionListener> listeners;

	private StartedGamePlayerNumbersGrid grid;

	private ArrayList<StartedGamePlayerNumberCellPanel> cells;

	public StartedGamePlayerNumbersGridPanel(StartedGamePlayerNumbersGrid grid) {

	}

	public void whenActionLaunched(PlayerNumbersGridActionListener listener) {

	}

}
