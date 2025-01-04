package com.turing_machine.views;

import com.turing_machine.started_game.StartedGamePlayerTestedCodesGrid;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGamePlayerTestedCodesPanel extends Displayable {

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

}
