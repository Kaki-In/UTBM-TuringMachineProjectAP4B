package com.turing_machine.views;

import java.util.ArrayList;
import com.turing_machine.listeners.CriterionCaseActionLaunchedListener;
import com.turing_machine.started_game.StartedGamePlayerCriterionCase;
import com.turing_machine.views.Displayable;
import java.awt.Component;

public class StartedGamePlayerCriterionCasePanel implements Displayable {

	private ArrayList<CriterionCaseActionLaunchedListener> listeners;

	private StartedGamePlayerCriterionCase displayed_case;

	public StartedGamePlayerCriterionCasePanel(StartedGamePlayerCriterionCase criterion_case) {

	}

	public void whenCriterionCaseActionLaunched(CriterionCaseActionLaunchedListener listener) {

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
