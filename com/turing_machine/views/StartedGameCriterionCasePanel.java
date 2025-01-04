package com.turing_machine.views;

import com.turing_machine.database.CriterionCase;
import com.turing_machine.database.CriterionCaseThumbnail;
import com.turing_machine.database.Database;
import com.turing_machine.exceptions.NoSuchCaseException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartedGameCriterionCasePanel extends Displayable {

	private final CriterionCase criterion_case;

	private final JPanel panel;

	public StartedGameCriterionCasePanel(CriterionCase criterion_case) {
		this.criterion_case = criterion_case;

		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

		this.panel.setBackground(new Color(230, 230, 230));
		this.panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		CriterionCaseThumbnail thumbnail;
		try{
			thumbnail = Database.getThumbnails().getCasesThumbnails().getCase(criterion_case.getId());
		} catch (NoSuchCaseException e)
		{
			System.err.println("Warning : couldn't find case thumbnail " + criterion_case.getId());
			return;
		}

		JLabel image = new JLabel(new DescriptableIcon(150, 63, thumbnail.getImage()));
		image.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		this.panel.add(image);

		JLabel description = new JLabel("<html><center>" + thumbnail.getDescription() + "</center></html>");
		description.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		description.setMaximumSize(new Dimension(150, 63));
		this.panel.add(description);
	}

	@Override
	public Component getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
	}

}
