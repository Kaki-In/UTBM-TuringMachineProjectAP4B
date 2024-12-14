package com.turing_machine.views;

import java.util.ArrayList;
import com.turing_machine.listeners.PlayerNumberCellActionListener;
import com.turing_machine.base_objects.CodeComponent;
import com.turing_machine.started_game.StartedGamePlayerNumbersGrid;

public class StartedGamePlayerNumberCellPanel implements Displayable {

	private ArrayList<PlayerNumberCellActionListener> listeners;

	private CodeComponent position;

	private StartedGamePlayerNumbersGrid grid;

	public StartedGamePlayerNumberCellPanel(CodeComponent position, StartedGamePlayerNumbersGrid grid) {

	}

	public void whenActionLaunched(PlayerNumberCellActionListener listener) {

	}

}
