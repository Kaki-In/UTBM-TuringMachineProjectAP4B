package com.turing_machine.views;

import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.started_game.StartedGamePlayerCriteria;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class StartedGamePlayerCriteriaPanel extends Displayable {

	private final StartedGamePlayerCriteria criteria;

	private final ArrayList<StartedGamePlayerCriterionPanel> criteria_views;

	private final JPanel panel;

	public StartedGamePlayerCriteriaPanel(StartedGamePlayerCriteria criteria) {
		this.criteria = criteria;

		this.criteria_views = new ArrayList<>();

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		for (int i=0; i < criteria.getCriteriaCount().toInteger(); ++i)
		{
			StartedGamePlayerCriterionPanel panel = new StartedGamePlayerCriterionPanel(criteria.getCriterion(CriterionLetter.fromInteger(i)));
			criteria_views.add(panel);

			panel.whenShouldReload(() -> reloadParent());

			GridBagConstraints criterionConstraint = new GridBagConstraints();
			criterionConstraint.gridx = 2*(i%2);
			criterionConstraint.gridy = 2*(i/2);
			criterionConstraint.gridwidth = 1;
			criterionConstraint.gridheight = 1;

			this.panel.add(panel.getWidget(), criterionConstraint);

			JPanel spacePanel = new JPanel();
			GridBagConstraints spaceConstraints = new GridBagConstraints();


			if (i%2 == 0) // un élément va suivre
			{
				spacePanel.setSize(new Dimension(30, 30));

				spaceConstraints.gridx = 2*(i%2) +1 ;
				spaceConstraints.gridy = 2*(i/2) ;
				spaceConstraints.gridwidth = 1;
				spaceConstraints.gridheight = 1;

			} else { // une ligne va suivre
				spacePanel.setSize(new Dimension(30, 30));

				spaceConstraints.gridx = 2*(i%2) ;
				spaceConstraints.gridy = 2*(i/2) + 1;
				spaceConstraints.gridwidth = 1;
				spaceConstraints.gridheight = 1;

			}

			this.panel.add(spacePanel, spaceConstraints);

		}

	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		for (StartedGamePlayerCriterionPanel criterion_panel: this.criteria_views)
		{
			criterion_panel.refresh();
		}
	}

}
