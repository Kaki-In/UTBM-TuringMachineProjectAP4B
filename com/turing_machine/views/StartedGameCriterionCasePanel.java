package com.turing_machine.views;

import com.turing_machine.database.CriterionCase;
import com.turing_machine.database.CriterionCaseThumbnail;
import com.turing_machine.database.Database;
import com.turing_machine.exceptions.NoSuchCaseException;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartedGameCriterionCasePanel implements Displayable {

	private final CriterionCase criterion_case;

	private final JPanel panel;

	public StartedGameCriterionCasePanel(CriterionCase criterion_case) {
		this.criterion_case = criterion_case;

		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

		CriterionCaseThumbnail thumbnail;
		try{
			thumbnail = Database.getThumbnails().getCasesThumbnails().getCase(criterion_case.getId());
		} catch (NoSuchCaseException e)
		{
			System.err.println("Warning : couldn't find case thumbnail " + criterion_case.getId());
			return;
		}

		this.panel.add(new JLabel(new DescriptableIcon(300, 125, thumbnail.getImage())));
		this.panel.add(new JLabel(thumbnail.getDescription()));
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
