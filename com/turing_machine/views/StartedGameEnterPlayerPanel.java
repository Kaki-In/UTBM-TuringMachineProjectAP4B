package com.turing_machine.views;

import com.turing_machine.base_objects.Code;
import com.turing_machine.listeners.StartedGameCodesLineListener;
import com.turing_machine.started_game.StartedGamePlayer;
import com.turing_machine.started_game.StartedGamePlayerTestedCodeValidationResult;
import com.turing_machine.started_game.StartedGamePlayerTestedCodesGrid;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StartedGameEnterPlayerPanel extends Displayable {

	private ArrayList<Runnable> listeners;

	private StartedGamePlayer player;

	private JPanel panel;

	private JLabel totalLabel;

	private JLabel verifLabel;

	private JLabel nameLabel;

	public StartedGameEnterPlayerPanel(StartedGamePlayer player) {
		this.listeners = new ArrayList<>();

		this.player = player;

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());
		this.panel.setBackground(new Color(220, 220, 220));
		this.panel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
		this.panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		GridBagConstraints nameConstraint = new GridBagConstraints();
		nameConstraint.gridx = 0;
		nameConstraint.gridy = 0;
		nameConstraint.gridwidth = 2;
		nameConstraint.weightx = 1;
		nameConstraint.anchor = GridBagConstraints.WEST;
		nameConstraint.fill = GridBagConstraints.HORIZONTAL;

		this.nameLabel = new JLabel(player.getName());
		this.nameLabel.setFont(Displayable.getFont(17).deriveFont(Font.BOLD));
		this.nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		Border compound = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0), BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		this.nameLabel.setBorder(compound);
		this.panel.add(this.nameLabel, nameConstraint);

		GridBagConstraints totalContraint = new GridBagConstraints();
		totalContraint.gridx = 0;
		totalContraint.gridy = 1;
		totalContraint.weightx = 1;
		totalContraint.anchor = GridBagConstraints.WEST;

		this.totalLabel = new JLabel("Aucune vérification");
		this.panel.add(this.totalLabel, totalContraint);

		GridBagConstraints verifConstraint = new GridBagConstraints();
		verifConstraint.gridx = 1;
		verifConstraint.gridy = 1;

		this.verifLabel = new JLabel("0/3");
		this.panel.add(this.verifLabel, verifConstraint);

		StartedGameCodesLineListener lineListener = new StartedGameCodesLineListener() {
			@Override
			public void onCodeDecided(Code code) {}

			@Override
			public void onVerificationDone(StartedGamePlayerTestedCodeValidationResult result) {
				reloadParent();
			}
		};

		player.getNotes().getTestedCodesGrid().getLineFromRound(0).whenNewValidation(lineListener);

		player.getNotes().getTestedCodesGrid().whenNewLine((line) -> {
			reloadParent();
			line.whenNewValidation(lineListener);
		});

		this.panel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (player.isEliminated())
				{
					JOptionPane.showMessageDialog(panel, "Ce joueur est éliminé", "Impossible d'ouvrir la feuille de note du joueur", JOptionPane.DEFAULT_OPTION);
				} else {
					for (Runnable listener: listeners)
					{
						listener.run();
					}
				}

				panel.setBackground(new Color(220, 220, 220));
			}

			@Override
			public void mousePressed(MouseEvent me) {}

			@Override
			public void mouseReleased(MouseEvent me) {}

			@Override
			public void mouseEntered(MouseEvent me) {
				if (!player.isEliminated())
				panel.setBackground(new Color(130, 200, 180));
			}

			@Override
			public void mouseExited(MouseEvent me) {
				panel.setBackground(new Color(220, 220, 220));
			}

		});

		this.panel.setPreferredSize(new Dimension(300, 70));
	}

	public void whenPlayerAskedToEnter(Runnable listener) {
		this.listeners.add(listener);
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		StartedGamePlayerTestedCodesGrid grid = this.player.getNotes().getTestedCodesGrid();
		int total = grid.getTotalValidationsCount();

		switch (total) {
			case 0:
				this.totalLabel.setText("Aucune validation");
				break;
			case 1:
				this.totalLabel.setText("Une seule validation");
				break;
			default:
				this.totalLabel.setText(total + " validations");
		}

		if (player.isEliminated())
		{
			this.panel.setCursor(Cursor.getDefaultCursor());
			this.nameLabel.setForeground(Color.GRAY);
			this.nameLabel.setText("<html><strike>" + this.player.getName() + "</strike></html>");
		} else {
			this.panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.nameLabel.setForeground(Color.BLACK);
			this.nameLabel.setText(this.player.getName());
		}

		this.verifLabel.setText(grid.getLineFromRound(grid.getState().getRoundId()).getValidationsCount() + "/3");
	}

}
