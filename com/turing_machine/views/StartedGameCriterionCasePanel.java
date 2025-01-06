package com.turing_machine.views;

import com.turing_machine.database.CriterionCase;
import com.turing_machine.database.CriterionCaseThumbnail;
import com.turing_machine.database.Database;
import com.turing_machine.exceptions.NoSuchCaseException;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartedGameCriterionCasePanel extends Displayable {

	private final CriterionCase criterion_case;

	private final JPanel panel;

	public StartedGameCriterionCasePanel(CriterionCase criterion_case) {
		this.criterion_case = criterion_case;

		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

		this.panel.setBackground(new Color(245, 255, 250));
		this.panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		CriterionCaseThumbnail thumbnail;
		try{
			thumbnail = Database.getThumbnails().getCasesThumbnails().getCase(criterion_case.getId());
		} catch (NoSuchCaseException e)
		{
			System.err.println("Warning : couldn't find case thumbnail " + criterion_case.getId());
			throw new AssertionError("something weird happened");
		}

		JLabel image = new JLabel(new DescriptableIcon(150, 63, thumbnail.getImage()));
		image.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		image.setHorizontalAlignment(JLabel.CENTER);
		this.panel.add(image);

		JLabel description = new JLabel("<html><center>" + thumbnail.getDescription() + "</center></html>");
		description.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		description.setHorizontalAlignment(JLabel.CENTER);
		description.setFont(Displayable.getFont(9));
		this.panel.add(description);

		this.panel.setPreferredSize(new Dimension(150, 120));
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
	}

}
