package com.turing_machine.views;

import com.turing_machine.database.CriterionCaseThumbnail;
import com.turing_machine.database.Database;
import com.turing_machine.exceptions.NoSuchCaseException;
import com.turing_machine.listeners.CriterionCaseChangeListener;
import com.turing_machine.started_game.StartedGamePlayerCriterionCase;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartedGamePlayerCriterionCasePanel extends Displayable {

	private final StartedGamePlayerCriterionCase displayed_case;

	private final JPanel panel;

	private final JLabel description;

	public StartedGamePlayerCriterionCasePanel(StartedGamePlayerCriterionCase criterion_case) {
		this.displayed_case = criterion_case;

		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

		this.panel.setBackground(new Color(230, 230, 230));
		this.panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		CriterionCaseThumbnail thumbnail;
		try{
			thumbnail = Database.getThumbnails().getCasesThumbnails().getCase(criterion_case.getCaseId());
		} catch (NoSuchCaseException e)
		{
			System.err.println("Warning : couldn't find case thumbnail " + criterion_case.getCaseId());
			throw new AssertionError("something weird happened");
		}

		this.description = new JLabel("<html><center>" + thumbnail.getDescription() + "</center></html>");
		this.description.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		this.description.setHorizontalAlignment(JLabel.CENTER);
		this.description.setFont(Displayable.getFont(10));
		this.panel.add(this.description);

		this.panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.panel.setPreferredSize(new Dimension(150, 30));

		criterion_case.whenValidationChanged(new CriterionCaseChangeListener() {
			@Override
			public void onCriterionCaseValidation() {
				reloadParent();
			}

			@Override
			public void onCriterionCaseUnvalidation() {
				reloadParent();
			}
	
		});

		this.panel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (criterion_case.is_validated())
				{
					criterion_case.unvalidate();
				} else {
					criterion_case.validate();
				}
			}

			@Override
			public void mousePressed(MouseEvent me) {}

			@Override
			public void mouseReleased(MouseEvent me) {}

			@Override
			public void mouseEntered(MouseEvent me) {
				panel.setBackground(new Color(180, 180, 180));
			}

			@Override
			public void mouseExited(MouseEvent me) {
				panel.setBackground(new Color(230, 230, 230));
			}
	
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
		CriterionCaseThumbnail thumbnail;

		try{
			thumbnail = Database.getThumbnails().getCasesThumbnails().getCase(displayed_case.getCaseId());
		} catch (NoSuchCaseException e)
		{
			System.err.println("Warning : couldn't find case thumbnail " + displayed_case.getCaseId());
			throw new AssertionError("something weird happened");
		}

		if (this.displayed_case.is_validated())
		{
			description.setText("<html><center>" + thumbnail.getDescription() + "</center></html>");
		} else {
			description.setText("<html><center><strike>" + thumbnail.getDescription() + "</strike></center></html>");
		}
	}

}
