package com.turing_machine.views;

import com.turing_machine.database.CriterionCase;
import java.awt.Component;

public class StartedGameCriterionCasePanel implements Displayable {

	private CriterionCase criterion_case;

	public StartedGameCriterionCasePanel(CriterionCase criterion_case) {

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
