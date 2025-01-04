package com.turing_machine.views;

import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.started_game.StartedGamePlayerTestedCodesGrid;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartedGamePlayerTestedCodesPanel extends Displayable {

	private StartedGamePlayerTestedCodesGrid codes_grid;

	private ArrayList<StartedGamePlayerTestedCodeLinePanel> lines;

	private JPanel panel;

	public StartedGamePlayerTestedCodesPanel(StartedGamePlayerTestedCodesGrid codes_grid) {
		this.codes_grid = codes_grid;

		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

		JPanel letters_panel = new JPanel();
		letters_panel.setLayout(new GridBagLayout()); // not a box layout to respect the dimensions

		JPanel blankSpace = new JPanel();
		blankSpace.setSize(new Dimension(30, 30));
		blankSpace.setPreferredSize(new Dimension(30, 30));
		letters_panel.add(blankSpace);

		this.panel.add(letters_panel);

		for (int i = 0; i < codes_grid.getState().getMachine().getCriteria().getCriteriaCount().toInteger(); ++i )
		{
			GridBagConstraints labelConstraint = new GridBagConstraints();
			labelConstraint.gridx = i + 1;

			JLabel label = new JLabel(CriterionLetter.fromInteger(i).name());
			label.setSize(new Dimension(30, 30));
			label.setPreferredSize(new Dimension(30, 30));
			letters_panel.add(label, labelConstraint);

		}

		this.lines = new ArrayList<>();

		StartedGamePlayerTestedCodeLinePanel first_line = new StartedGamePlayerTestedCodeLinePanel(codes_grid.getLineFromRound(0));
		this.lines.add(first_line);
		first_line.whenShouldReload(() -> reloadParent());

		this.panel.add(first_line.getWidget());

		codes_grid.whenNewLine((line) -> {
			StartedGamePlayerTestedCodeLinePanel displayed_line = new StartedGamePlayerTestedCodeLinePanel(line);
			this.lines.add(displayed_line);
			displayed_line.whenShouldReload(() -> reloadParent());

			this.panel.add(displayed_line.getWidget());
		});
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		for (StartedGamePlayerTestedCodeLinePanel line: this.lines)
		{
			line.refresh();
		}
	}

}
