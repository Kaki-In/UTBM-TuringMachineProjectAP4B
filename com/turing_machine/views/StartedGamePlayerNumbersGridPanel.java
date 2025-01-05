package com.turing_machine.views;

import com.turing_machine.base_objects.CodeComponent;
import com.turing_machine.base_objects.CodeIndex;
import com.turing_machine.base_objects.CodeValue;
import com.turing_machine.started_game.StartedGamePlayerNumbersGrid;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartedGamePlayerNumbersGridPanel extends Displayable {

	private final StartedGamePlayerNumbersGrid grid;

	private final ArrayList<StartedGamePlayerNumberCellPanel> cells;

	private final JPanel panel;

	public StartedGamePlayerNumbersGridPanel(StartedGamePlayerNumbersGrid grid) {
		this.grid = grid;
		
		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		for (int i=0; i < 3; ++i)
		{
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.gridx = i;
			constraints.gridy = 0;

			JLabel label = new JLabel(new IndexIcon(CodeIndex.fromInteger(i), 50));
			label.setPreferredSize(new Dimension(50, 50));
			label.setHorizontalAlignment(JLabel.CENTER);

			this.panel.add(label, constraints);
		}

		this.cells = new ArrayList<>();

		for (int x = 0; x < 3; ++x)
		{
			for (int y = 0; y < 5; ++y)
			{
				GridBagConstraints constraints = new GridBagConstraints();
				constraints.gridx = x;
				constraints.gridy = y + 1;

				StartedGamePlayerNumberCellPanel cell = new StartedGamePlayerNumberCellPanel(new CodeComponent(CodeIndex.fromInteger(x), CodeValue.fromInteger(y + 1)), grid);

				this.cells.add(cell);
				
				this.panel.add(cell.getWidget(), constraints);

				cell.whenShouldReload(() -> reloadParent());
			}
		}

		this.panel.setMinimumSize(this.panel.getPreferredSize());
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		for (StartedGamePlayerNumberCellPanel cell : this.cells)
		{
			cell.refresh();
		}
	}

}
