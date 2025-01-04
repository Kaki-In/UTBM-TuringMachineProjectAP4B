package com.turing_machine.views;

import com.turing_machine.base_objects.CodeComponent;
import com.turing_machine.started_game.StartedGamePlayerNumbersGrid;
import java.awt.Component;

public class StartedGamePlayerNumberCellPanel extends Displayable {

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

}
