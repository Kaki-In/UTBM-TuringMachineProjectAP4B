package com.turing_machine.views;

import com.turing_machine.base_objects.CodeComponent;
import com.turing_machine.listeners.PlayerNumberCellActionListener;
import com.turing_machine.started_game.StartedGamePlayerNumbersGrid;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGamePlayerNumberCellPanel implements Displayable {

	private ArrayList<PlayerNumberCellActionListener> listeners;

	private CodeComponent position;

	private StartedGamePlayerNumbersGrid grid;

	public StartedGamePlayerNumberCellPanel(CodeComponent position, StartedGamePlayerNumbersGrid grid) {

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

	public void whenActionLaunched(PlayerNumberCellActionListener listener) {

	}

}
