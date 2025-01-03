package com.turing_machine.views;

import com.turing_machine.platform_state.GameDebriefingStep;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameDebriefPanel extends GameDisplayedPanel {

	private final GameDebriefingStep debrief;

	private final GameWinnersPanel winners;

    private final MachineDiscoveringPanel machine;

    private final JPanel panel;

    private final JButton restartButton;

	public GameDebriefPanel(GameDebriefingStep step) {
		super(step);
        this.debrief = step;

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		GridBagConstraints titleConstraints = new GridBagConstraints();
		titleConstraints.gridx = 0;
		titleConstraints.gridy = 0;
		titleConstraints.gridwidth = 2;
		titleConstraints.gridheight = 1;
		titleConstraints.fill = GridBagConstraints.VERTICAL;
		titleConstraints.anchor = GridBagConstraints.CENTER;
		titleConstraints.weighty = 1;

		JLabel title_label = new JLabel("Résultats de la partie");
		title_label.setFont(Displayable.getFont(30));
		this.panel.add(title_label, titleConstraints);

		GridBagConstraints codeConstraints = new GridBagConstraints();
		codeConstraints.gridx = 0;
		codeConstraints.gridy = 1;
		codeConstraints.gridwidth = 1;
		codeConstraints.gridheight = 1;
		codeConstraints.fill = GridBagConstraints.BOTH;
		titleConstraints.weightx = 1;
		titleConstraints.weighty = 3;

		this.machine = new MachineDiscoveringPanel(step.getMachine());
		this.panel.add(this.machine.getWidget(), codeConstraints);
		
		GridBagConstraints playersConstraint = new GridBagConstraints();
		playersConstraint.gridx = 1;
		playersConstraint.gridy = 1;
		playersConstraint.gridwidth = 1;
		playersConstraint.gridheight = 1;
		playersConstraint.fill = GridBagConstraints.BOTH;
		titleConstraints.weightx = 1;
		titleConstraints.weighty = 3;

		this.winners = new GameWinnersPanel(step.getWinners());
		this.panel.add(this.winners.getWidget(), playersConstraint);
		
		GridBagConstraints buttonConstraint = new GridBagConstraints();
		buttonConstraint.gridx = 0;
		buttonConstraint.gridy = 2;
		buttonConstraint.gridwidth = 2;
		buttonConstraint.gridheight = 1;
		buttonConstraint.fill = GridBagConstraints.VERTICAL;
		buttonConstraint.anchor = GridBagConstraints.CENTER;

		this.restartButton = new JButton("Rejouer");
		this.panel.add(this.restartButton, buttonConstraint);

		this.restartButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
                step.playAgain();
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

    @Override
    public void refresh() {
        this.machine.refresh();
        this.winners.refresh();
    }

    @Override
    public Component getWidget() {
        return this.panel;
    }

}
