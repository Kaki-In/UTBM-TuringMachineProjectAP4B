package com.turing_machine.views;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.exceptions.GameConstraintException;
import com.turing_machine.listeners.StartedGameCodesLineListener;
import com.turing_machine.started_game.StartedGamePlayerTestedCodeValidationResult;
import com.turing_machine.started_game.StartedGamePlayerTestedCodesLine;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartedGamePlayerTestedCodeLinePanel extends Displayable {

	private StartedGamePlayerTestedCodesLine line;
	
	private JLabel[] checkable_labels;
	private CheckIcon[] check_icons;

	private JPanel panel;

	private JLabel code_label;

	public StartedGamePlayerTestedCodeLinePanel(StartedGamePlayerTestedCodesLine line) {
		this.line = line;

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout()); // pas un BoxLayout pour respected les tailles

		GridBagConstraints labelConstraint = new GridBagConstraints();
		labelConstraint.gridx = 0;
		labelConstraint.gridy = 0;

		this.code_label = new JLabel("---");
		this.code_label.setBackground(new Color(255, 255, 255));
		this.code_label.setPreferredSize(new Dimension(30, 30));
		this.code_label.setMinimumSize(new Dimension(30, 30));
		this.code_label.setSize(new Dimension(30, 30));
		this.code_label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		this.code_label.setHorizontalAlignment(JLabel.CENTER);
		this.code_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		this.panel.add(this.code_label, labelConstraint);

		int criteria_count = line.getState().getMachine().getCriteria().getCriteriaCount().toInteger();
		this.check_icons = new CheckIcon[criteria_count];
		this.checkable_labels = new JLabel[criteria_count];

		for (int i=0; i < criteria_count; ++i)
		{
			this.check_icons[i] = new CheckIcon(null);
			this.checkable_labels[i] = new JLabel(this.check_icons[i]);

			GridBagConstraints checkConstraint = new GridBagConstraints();
			checkConstraint.gridx = i + 1;
			checkConstraint.gridy = 0;

			this.panel.add(this.checkable_labels[i], checkConstraint);

			CriterionLetter letter_just_now = CriterionLetter.fromInteger(i);

			this.checkable_labels[i].addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent me) {
					/* On vérifie que ce n'est pas déjà fait */

					for (StartedGamePlayerTestedCodeValidationResult validation : line.getCodeValidationResults())
					{
						if (validation.getCriterionLetter() == letter_just_now)
						{
							return;
						}
					}

					// Sinon, on peut faire la vérification

					try {
						line.verify(letter_just_now);
					} catch (GameConstraintException e) {
						switch (e.getMessage())
						{
							case "can't verify more than 3 times in a round":
								JOptionPane.showConfirmDialog(panel, "Vous avez déjà dépassé les 3 vérifications par manche", "Impossible de vérifier le critère", JOptionPane.DEFAULT_OPTION);
								break;
								
							case "please choose first a code!":
								JOptionPane.showConfirmDialog(panel, "Veuillez d'abord choisir un code!", "Impossible de vérifier le critère", JOptionPane.DEFAULT_OPTION);
								break;
								
							case "this round is finished yet":
								JOptionPane.showConfirmDialog(panel, "La manche est déjà terminée", "Impossible de vérifier le critère", JOptionPane.DEFAULT_OPTION);
								break;
							
							default:
								JOptionPane.showConfirmDialog(panel, e.getMessage(), "Impossible de vérifier le critère", JOptionPane.DEFAULT_OPTION);
								break;
								
						}
					}
				}

				@Override
				public void mousePressed(MouseEvent me) {}

				@Override
				public void mouseReleased(MouseEvent me) {}

				@Override
				public void mouseEntered(MouseEvent me) {}

				@Override
				public void mouseExited(MouseEvent me) {}
	
			});

		}

		this.code_label.setOpaque(true);
		this.code_label.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (line.getRoundId() != line.getState().getRoundId())
				{
					JOptionPane.showConfirmDialog(panel, "La manche est déjà terminée", "Impossible de choisir le code", JOptionPane.DEFAULT_OPTION);
				} else if (line.getCode() == null || line.getValidationsCount() == 0) 
				{
					ChooseCodePanel code_chooser = new ChooseCodePanel();

					// ask for code

					int result = JOptionPane.showConfirmDialog(null, new JComponent[] { code_chooser.getWidget() }, "Merci d'entrer un code", JOptionPane.PLAIN_MESSAGE);

					if (result == JOptionPane.OK_OPTION) {
						try {
							line.setCode(code_chooser.getCode());
						} catch (GameConstraintException e) {
							JOptionPane.showConfirmDialog(panel, "Vous avez déjà vérifié un code pour cette manche, impossible d'en choisir un autre", "Impossible de choisir le code", JOptionPane.DEFAULT_OPTION);
						}
					}
				} else {
					JOptionPane.showConfirmDialog(panel, "Vous avez déjà vérifié un code pour cette manche, impossible d'en choisir un autre", "Impossible de choisir le code", JOptionPane.DEFAULT_OPTION);				}
			}

			@Override
			public void mousePressed(MouseEvent me) {}

			@Override
			public void mouseReleased(MouseEvent me) {}

			@Override
			public void mouseEntered(MouseEvent me) {
				if ((line.getCode() == null || line.getValidationsCount() == 0) && line.getRoundId() == line.getState().getRoundId()) 
				{
					code_label.setBackground(new Color(200, 200, 200));
				} else {
					code_label.setBackground(new Color(255, 255, 255));
				}
			}

			@Override
			public void mouseExited(MouseEvent me) {
				code_label.setBackground(new Color(255, 255, 255));
			}

		});

		line.whenNewValidation(new StartedGameCodesLineListener() {
			@Override
			public void onCodeDecided(Code code) {
				reloadParent();
			}

			@Override
			public void onVerificationDone(StartedGamePlayerTestedCodeValidationResult result) {
				int index = result.getCriterionLetter().toInteger();

				check_icons[index].setChecked(result.hasMatched());

				reloadParent();
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
		if (this.line.getCode() == null)
		{
			this.code_label.setText("---");

		} else {
			this.code_label.setText(this.line.getCode().toString());
		}

		if ((line.getCode() == null || line.getValidationsCount() == 0) && line.getRoundId() == line.getState().getRoundId())
		{
			this.code_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else {
			this.code_label.setCursor(Cursor.getDefaultCursor());
		}

		for (JLabel label: this.checkable_labels)
		{
			label.repaint();

			if (line.getValidationsCount() == 3) 
			{
				label.setCursor(Cursor.getDefaultCursor());
			} else {
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		}
	}

}
