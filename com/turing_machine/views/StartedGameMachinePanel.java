package com.turing_machine.views;

import com.turing_machine.started_game.StartedGameMachine;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGameMachinePanel implements Displayable {

	private StartedGameMachine machine;

	private ArrayList<StartedGameCriterionCasePanel> criteria;

	public StartedGameMachinePanel(StartedGameMachine machine) {

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
