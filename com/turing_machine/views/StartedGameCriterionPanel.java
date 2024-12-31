package com.turing_machine.views;

import com.turing_machine.database.Criterion;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGameCriterionPanel implements Displayable {

	private Criterion criterion;

	private ArrayList<StartedGameCriterionCasePanel> cases;

	public StartedGameCriterionPanel(Criterion criterion) {

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
