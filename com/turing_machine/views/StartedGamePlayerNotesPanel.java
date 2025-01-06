package com.turing_machine.views;

import com.turing_machine.base_objects.Code;
import com.turing_machine.listeners.StartedGamePlayerEventsListener;
import com.turing_machine.started_game.StartedGamePlayer;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StartedGamePlayerNotesPanel extends Displayable {

	private final ArrayList<Runnable> listeners;

	private final StartedGamePlayer player;

	private final StartedGamePlayerNumbersGridPanel numbers;

	private final StartedGamePlayerCriteriaPanel criteria;

	private final StartedGamePlayerTestedCodesPanel codes;

	private final JPanel panel;

	private final JButton exitButton;

	private final JButton guessButton;

	public StartedGamePlayerNotesPanel(StartedGamePlayer player) {
		this.listeners = new ArrayList<>();
		this.player = player;

		this.numbers = new StartedGamePlayerNumbersGridPanel(player.getNotes().getNumbersGrid());
		this.criteria = new StartedGamePlayerCriteriaPanel(player.getNotes().getCriteria());
		this.codes = new StartedGamePlayerTestedCodesPanel(player.getNotes().getTestedCodesGrid());

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		JPanel first_line_panel = new JPanel();
		first_line_panel.setLayout(new GridBagLayout()); // pour s'assurer que le nom va à droite ; on mets dans un layout séparé pour ne pas influencer le reste
		Border compound = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		compound = BorderFactory.createCompoundBorder(compound, BorderFactory.createEmptyBorder(5, 5, 5, 5));
		first_line_panel.setBorder(compound);
		first_line_panel.setBackground(new Color(100, 127, 110));

		GridBagConstraints buttonConstraints = new GridBagConstraints();
		buttonConstraints.gridx = 0;
		buttonConstraints.gridy = 0;
		buttonConstraints.weightx = 0;

		this.exitButton = new JButton("Fermer la feuille de notes");
		first_line_panel.add(this.exitButton, buttonConstraints);

		GridBagConstraints nameConstraints = new GridBagConstraints();
		nameConstraints.gridx = 1;
		nameConstraints.gridy = 0;
		nameConstraints.weightx = 1;

		JLabel name_label = new JLabel(player.getName());
		first_line_panel.add(name_label, nameConstraints);

		GridBagConstraints guessConstraints = new GridBagConstraints();
		guessConstraints.gridx = 2;
		guessConstraints.gridy = 0;
		guessConstraints.weightx = 0;

		this.guessButton = new JButton("Code trouvé!");
		first_line_panel.add(this.guessButton, guessConstraints);

		GridBagConstraints firstLineConstraints = new GridBagConstraints();
		firstLineConstraints.gridx = 0;
		firstLineConstraints.gridy = 0;
		firstLineConstraints.gridwidth = 2;
		firstLineConstraints.gridheight = 1;
		firstLineConstraints.weightx = 1;
		firstLineConstraints.fill = GridBagConstraints.HORIZONTAL;
		
		this.panel.add(first_line_panel, firstLineConstraints);

		GridBagConstraints numbersConstraints = new GridBagConstraints();
		numbersConstraints.gridx = 1;
		numbersConstraints.gridy = 2;
		numbersConstraints.gridwidth = 1;
		numbersConstraints.gridheight = 1;
		
		this.panel.add(this.numbers.getWidget(), numbersConstraints);

		GridBagConstraints criteriaConstraints = new GridBagConstraints();
		criteriaConstraints.gridx = 0;
		criteriaConstraints.gridy = 1;
		criteriaConstraints.gridwidth = 1;
		criteriaConstraints.gridheight = 2;
		criteriaConstraints.weightx = 1;
		
		this.panel.add(this.criteria.getWidget(), criteriaConstraints);

		GridBagConstraints codesConstraints = new GridBagConstraints();
		codesConstraints.gridx = 1;
		codesConstraints.gridy = 1;
		codesConstraints.gridwidth = 1;
		codesConstraints.gridheight = 1;
		codesConstraints.weighty = 1;
		codesConstraints.anchor = GridBagConstraints.NORTH;
		
		this.panel.add(this.codes.getWidget(), codesConstraints);

		this.codes.whenShouldReload(() -> reloadParent());
		this.criteria.whenShouldReload(() -> reloadParent());
		this.numbers.whenShouldReload(() -> reloadParent());
		
		this.exitButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				for (Runnable listener: listeners)
				{
					listener.run();
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

		this.guessButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (player.isGuessingACode()) return;

				int result = JOptionPane.showConfirmDialog(panel, "Êtes-vous sûr d'avoir trouvé le code de la machine?", "Vous risquez une élimination", JOptionPane.OK_CANCEL_OPTION);
				if (result != JOptionPane.OK_OPTION) return;

				ChooseCodePanel code_chooser = new ChooseCodePanel();

				result = JOptionPane.showConfirmDialog(null, new JComponent[] { code_chooser.getWidget() }, "Merci d'entrer un code", JOptionPane.PLAIN_MESSAGE);

				if (result == JOptionPane.OK_OPTION) {
					player.guessCode(code_chooser.getCode());
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

		player.whenEventEmitted(new StartedGamePlayerEventsListener() {
			@Override
			public void onPlayerEliminated() {
				javax.swing.SwingUtilities.invokeLater(() -> { // on n'est pas sur d'être dans la JTE
					JOptionPane.showMessageDialog(panel, player.getName() + " a deviné le mauvais code (" + player.getGuessingCode().toString() + ")et est éliminé de la partie!", "Élimination d'un joueur", JOptionPane.OK_OPTION);
				});
			}

			@Override
			public void onPlayerDisabled() {}

			@Override
			public void onPlayerEnabled() {}

			@Override
			public void onPlayerMadeHypothesis(Code code) {
				reloadParent();
			}

		});
	}

	public StartedGamePlayer getPlayer()
	{
		return this.player;
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		this.codes.refresh();
		this.criteria.refresh();
		this.numbers.refresh();

		this.guessButton.setEnabled(!this.player.isGuessingACode());
	}

	public void whenCloseAction(Runnable listener) {
		this.listeners.add(listener);
	}

}
