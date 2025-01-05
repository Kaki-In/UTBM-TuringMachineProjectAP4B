package com.turing_machine.views;

import com.turing_machine.base_objects.CodeComponent;
import com.turing_machine.listeners.PlayerNumbersGridChangeListener;
import com.turing_machine.started_game.StartedGamePlayerNumbersGrid;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class StartedGamePlayerNumberCellPanel extends Displayable {

	private final CodeComponent position;

	private final StartedGamePlayerNumbersGrid grid;

	private final JLabel label;

	public StartedGamePlayerNumberCellPanel(CodeComponent position, StartedGamePlayerNumbersGrid grid) {
		this.position = position;
		this.grid = grid;

		this.label = new JLabel("" + position.getValue().toInteger());
		this.label.setBackground(new Color(255, 255, 255));
		this.label.setOpaque(true);
		this.label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		this.label.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		this.label.setHorizontalAlignment(JLabel.CENTER);
		this.label.setVerticalAlignment(JLabel.CENTER);

		this.label.setPreferredSize(new Dimension(50, 50));

		this.label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		this.label.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (grid.numberIsUnvalidated(position))
				{
					grid.validateNumber(position);
				} else {
					grid.unvalidateNumber(position);
				}
			}

			@Override
			public void mousePressed(MouseEvent me) {}

			@Override
			public void mouseReleased(MouseEvent me) {}

			@Override
			public void mouseEntered(MouseEvent me) {
				label.setBackground(new Color(220, 220, 220));
			}

			@Override
			public void mouseExited(MouseEvent me) {
				label.setBackground(new Color(255, 255, 255));
			}

		});

		grid.whenNumberStatusChanged(new PlayerNumbersGridChangeListener() {
			@Override
			public void onNumberValidated(CodeComponent code_position) {
				if (code_position.equals(position))
				{
					reloadParent();
				}
			}

			@Override
			public void onNumberUnvalidated(CodeComponent code_position) {
				if (code_position.equals(position))
				{
					reloadParent();
				}
			}

		});
	}

	@Override
	public JComponent getWidget()
	{
		return this.label;
	}

	@Override
	public void refresh()
	{
		if (this.grid.numberIsUnvalidated(this.position))
		{
			this.label.setForeground(new Color(200, 200, 200));
		} else {
			this.label.setForeground(Color.BLACK);
		}
	}

}
