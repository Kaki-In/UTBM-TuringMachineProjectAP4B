package com.turing_machine.views;

import com.turing_machine.configuration.MachineConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CodeConfigurationPanel extends Displayable {

	private final MachineConfiguration configuration;

	private final JPanel panel;

	private final JCheckBox checkbox;

	private final GameDifficultySelectionPanel difficulty;

	private final CriteriaCountSelectionPanel count;

	private boolean uses_api;

	public CodeConfigurationPanel(MachineConfiguration configuration) {
		this.configuration = configuration;

		this.panel = new JPanel();

		GridBagLayout layout = new GridBagLayout();
		this.panel.setLayout(layout);

		GridBagConstraints titleLabelConstraint = new GridBagConstraints();
		titleLabelConstraint.gridx = 0;
		titleLabelConstraint.gridy = 0;
		titleLabelConstraint.gridwidth = 2;
		titleLabelConstraint.gridheight = 1;
		titleLabelConstraint.fill = GridBagConstraints.VERTICAL;
		titleLabelConstraint.anchor = GridBagConstraints.CENTER;
		titleLabelConstraint.weighty = 1;

		JLabel title_label = new JLabel("Génération du code");
		title_label.setFont(Displayable.getFont(20));
		this.panel.add(title_label, titleLabelConstraint);
		
		GridBagConstraints difficultyLabelConstraint = new GridBagConstraints();
		difficultyLabelConstraint.gridx = 0;
		difficultyLabelConstraint.gridy = 1;
		difficultyLabelConstraint.anchor = GridBagConstraints.WEST;
		this.panel.add(new JLabel("Difficulté : "), difficultyLabelConstraint);
		
		this.difficulty = new GameDifficultySelectionPanel();
		this.difficulty.setGameDifficulty(difficulty.getGameDifficulty());

		GridBagConstraints difficultyConstraint = new GridBagConstraints();
		difficultyConstraint.gridx = 1;
		difficultyConstraint.gridy = 1;
		difficultyConstraint.weightx = 1;
		difficultyConstraint.fill = GridBagConstraints.HORIZONTAL;
		this.panel.add(this.difficulty.getWidget(), difficultyConstraint);
		
		this.count = new CriteriaCountSelectionPanel();
		this.count.setCriteriaCount(configuration.getCriteriaCount());

		GridBagConstraints countLabelConstraint = new GridBagConstraints();
		countLabelConstraint.gridx = 0;
		countLabelConstraint.gridy = 2;
		countLabelConstraint.anchor = GridBagConstraints.WEST;
		this.panel.add(new JLabel("Nombre de critères : "), countLabelConstraint);
		
		GridBagConstraints countConstraint = new GridBagConstraints();
		countConstraint.gridx = 1;
		countConstraint.gridy = 2;
		countConstraint.weightx = 1;
		countConstraint.fill = GridBagConstraints.HORIZONTAL;
		this.panel.add(this.count.getWidget(), countConstraint);

		GridBagConstraints apiLabelConstraint = new GridBagConstraints();
		apiLabelConstraint.gridx = 0;
		apiLabelConstraint.gridy = 3;
		apiLabelConstraint.anchor = GridBagConstraints.WEST;
		this.panel.add(new JLabel("Utiliser l'API de Turing Machine"), apiLabelConstraint);
		
		this.checkbox = new JCheckBox();
		GridBagConstraints apiConstraint = new GridBagConstraints();
		apiConstraint.gridx = 1;
		apiConstraint.gridy = 3;
		apiConstraint.anchor = GridBagConstraints.WEST;
		this.panel.add(this.checkbox, apiConstraint);

		this.uses_api = configuration.getUsesApi();

		this.checkbox.setSelected(this.uses_api);

		configuration.whenCriteriaCountChanged((last_count, new_count) -> {
			this.count.setCriteriaCount(new_count);
			reloadParent();
		});

		configuration.whenGameDifficultyChanged((last_difficulty, new_difficulty) -> {
			this.difficulty.setGameDifficulty(new_difficulty);
			reloadParent();
		});

		configuration.whenUsesApiChanged((last_used, now_uses) -> {
			this.setUsesApi(now_uses);
			reloadParent();
		});

		this.difficulty.whenGameDifficultySelected(difficulty -> {
			configuration.setGameDifficulty(difficulty);
		});

		this.difficulty.whenShouldReload(() -> {
			this.reloadParent();
		});

		this.count.whenCriteriaCountSelected(count -> {
			configuration.setCriteriaCount(count);
		});

		this.count.whenShouldReload(() -> {
			this.reloadParent();
		});

		this.checkbox.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				configuration.setUsesApi(checkbox.isSelected());
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
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		this.difficulty.setGameDifficulty(configuration.getGameDifficulty());
		this.difficulty.refresh();

		this.count.setCriteriaCount(configuration.getCriteriaCount());
		this.count.refresh();

		this.checkbox.setSelected(uses_api);
	}

	public boolean getUsesApi()
	{
		return this.uses_api;
	}

	public void setUsesApi(boolean enabled)
	{
		if (enabled == this.uses_api) return;

		this.uses_api = enabled;

		configuration.setUsesApi(enabled);
	}

}
