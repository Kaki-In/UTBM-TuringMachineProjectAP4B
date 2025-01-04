package com.turing_machine.views;

import com.turing_machine.started_game.StartedGamePlayerCriteria;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGamePlayerCriteriaPanel extends Displayable {

	private StartedGamePlayerCriteria criteria;

	private ArrayList<StartedGameCriterionPanel> criteria_views;

	public StartedGamePlayerCriteriaPanel(StartedGamePlayerCriteria criteria) {

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
