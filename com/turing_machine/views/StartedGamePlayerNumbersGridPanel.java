package com.turing_machine.views;

import com.turing_machine.started_game.StartedGamePlayerNumbersGrid;
import javax.swing.JComponent;
import java.util.ArrayList;

public class StartedGamePlayerNumbersGridPanel extends Displayable {

	private StartedGamePlayerNumbersGrid grid;

	private ArrayList<StartedGamePlayerNumberCellPanel> cells;

	public StartedGamePlayerNumbersGridPanel(StartedGamePlayerNumbersGrid grid) {

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

}
