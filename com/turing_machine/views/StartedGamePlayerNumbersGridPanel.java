package com.turing_machine.views;

import com.turing_machine.listeners.PlayerNumbersGridActionListener;
import com.turing_machine.started_game.StartedGamePlayerNumbersGrid;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGamePlayerNumbersGridPanel implements Displayable {

	private ArrayList<PlayerNumbersGridActionListener> listeners;

	private StartedGamePlayerNumbersGrid grid;

	private ArrayList<StartedGamePlayerNumberCellPanel> cells;

	public StartedGamePlayerNumbersGridPanel(StartedGamePlayerNumbersGrid grid) {

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

	public void whenActionLaunched(PlayerNumbersGridActionListener listener) {

	}

}
