package com.turing_machine.views;

import com.turing_machine.database.Criterion;
import com.turing_machine.database.CriterionCase;
import com.turing_machine.database.CriterionThumbnail;
import com.turing_machine.database.Database;
import com.turing_machine.exceptions.NoSuchCriterionException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartedGameCriterionPanel extends Displayable {

	private Criterion criterion;

	private ArrayList<StartedGameCriterionCasePanel> cases;

	private JPanel panel;

	public StartedGameCriterionPanel(Criterion criterion) {
		this.criterion = criterion;

		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

		this.panel.setBackground(new Color(230, 230, 230));
		this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel criterion_panel = new JPanel();
		criterion_panel.setLayout(new BoxLayout(criterion_panel, BoxLayout.X_AXIS));
		
		CriterionThumbnail thumbnail;
		try {
			thumbnail = Database.getThumbnails().getCriteriaThumbnails().getCriterionThumbnail(criterion.getId());
		} catch (NoSuchCriterionException e) {
			System.err.println("Warning : couldn't find criterion thumbnail " + criterion.getId());
			return;
		}

		JLabel image = new JLabel(new DescriptableIcon(100, 80, thumbnail.getMainThumbnail()));
		image.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		criterion_panel.add(image);

		JPanel description_panel = new JPanel();
		description_panel.setLayout(new BoxLayout(description_panel, BoxLayout.Y_AXIS));

		JLabel introduction = new JLabel("<html>Ce critère vérifie...</html>");
		introduction.setFont(Displayable.getFont(13));
		introduction.setMaximumSize(new Dimension(150, 80));
		introduction.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		description_panel.add(introduction);

		JLabel description = new JLabel("<html>" + thumbnail.getDescription() + "</html>");
		description.setMaximumSize(new Dimension(150, 80));
		description.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		description_panel.add(description);

		criterion_panel.add(description_panel);

		this.panel.add(criterion_panel);

		JPanel cases_panel = new JPanel();
		cases_panel.setLayout(new GridBagLayout());

		this.cases = new ArrayList<>();

		ArrayList<CriterionCase> cases = criterion.getDistinctCases();

		int columns;
		switch (cases.size()) {
			case 2:
				columns = 2;
				break;

			case 3:
				columns = 3;
				break;
			
			case 4:
				columns = 2;
				break;
			
			case 6:
				columns = 3;
				break;
			
			case 9:
				columns = 3;
				break;

			default:
				columns = Math.round((float) Math.sqrt(cases.size())) + 1; // peu probable, mais logiquement possible
		}

		for (int i = 0; i < cases.size(); ++i)
		{
			StartedGameCriterionCasePanel case_panel = new StartedGameCriterionCasePanel(cases.get(i));
			this.cases.add(case_panel);

			GridBagConstraints caseConstraints = new GridBagConstraints();
			caseConstraints.gridx = i%columns;
			caseConstraints.gridy = i/columns;
			caseConstraints.gridwidth = 1;
			caseConstraints.gridheight = 1;

			cases_panel.add(case_panel.getWidget(), caseConstraints);
		}
		this.panel.add(cases_panel);
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
