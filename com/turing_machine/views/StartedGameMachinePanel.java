package com.turing_machine.views;

import com.turing_machine.started_game.StartedGameCriterion;
import com.turing_machine.started_game.StartedGameMachine;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartedGameMachinePanel extends Displayable {

	private final StartedGameMachine machine;

	private final ArrayList<StartedGameCriterionPanel> criteria;

	private final JPanel panel;

	public StartedGameMachinePanel(StartedGameMachine machine) {
		this.machine = machine;

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		GridBagConstraints titleLabelConstraint = new GridBagConstraints();
		titleLabelConstraint.gridx = 0;
		titleLabelConstraint.gridy = 0;
		titleLabelConstraint.gridwidth = 4;
		titleLabelConstraint.gridheight = 1;

		JLabel titleLabel = new JLabel("Machine");
		titleLabel.setFont(Displayable.getFont(20));
		this.panel.add(titleLabel, titleLabelConstraint);

		this.criteria = new ArrayList<>();

		ArrayList<StartedGameCriterion> criteria_list = machine.getCriteria().getCriteria();

		for (int i=0; i < machine.getCriteria().getCriteriaCount().toInteger(); ++i)
		{
			StartedGameCriterion game_criterion = criteria_list.get(i);
			
			StartedGameCriterionPanel criterion_panel = new StartedGameCriterionPanel(game_criterion);
			this.criteria.add(criterion_panel);

			GridBagConstraints criterionConstraint = new GridBagConstraints();
			criterionConstraint.gridx = 2*(i%2);
			criterionConstraint.gridy = 2*(i/2) + 1;
			criterionConstraint.gridwidth = 1;
			criterionConstraint.gridheight = 1;

			this.panel.add(criterion_panel.getWidget(), criterionConstraint);

			JPanel spacePanel = new JPanel();
			GridBagConstraints spaceConstraints = new GridBagConstraints();


			if (i%2 == 0) // un élément va suivre
			{
				spacePanel.setSize(new Dimension(30, 30));

				spaceConstraints.gridx = 2*(i%2) + 1;
				spaceConstraints.gridy = 2*(i/2) + 1;
				spaceConstraints.gridwidth = 1;
				spaceConstraints.gridheight = 1;

			} else { // une ligne va suivre
				spacePanel.setSize(new Dimension(30, 30));

				spaceConstraints.gridx = 2*(i%2) ;
				spaceConstraints.gridy = 2*(i/2) + 2;
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
	}

}
