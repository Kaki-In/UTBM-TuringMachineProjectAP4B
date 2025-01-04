package com.turing_machine.views;

import com.turing_machine.started_game.StartedGamePlayerCriterion;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGamePlayerCriterionPanel extends Displayable {

	private StartedGamePlayerCriterion criterion;

	private ArrayList<StartedGameCriterionCasePanel> cases;

	public StartedGamePlayerCriterionPanel(StartedGamePlayerCriterion criterion) {

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
