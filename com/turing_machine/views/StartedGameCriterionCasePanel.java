package com.turing_machine.views;

import com.turing_machine.database.CriterionCase;
import java.awt.Component;
import javax.swing.JPanel;

public class StartedGameCriterionCasePanel implements Displayable {

	private final CriterionCase criterion_case;

	private final JPanel panel;

	public StartedGameCriterionCasePanel(CriterionCase criterion_case) {
		this.criterion_case = criterion_case;

		this.panel = new JPanel();
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
