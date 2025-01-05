package com.turing_machine.views;

import com.turing_machine.platform_state.StartedGameStep;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class StartedGamePanel extends GameDisplayedPanel {

	private final StartedGameSwitchPanel content;

	private final JPanel panel;

	public StartedGamePanel(StartedGameStep game) {
		super(game);

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		GridBagConstraints contentConstraints = new GridBagConstraints();
		contentConstraints.gridx = 0;
		contentConstraints.gridy = 0;
		contentConstraints.fill = GridBagConstraints.BOTH;

		this.content = new StartedGameSwitchPanel(game.getStartedGame());

		this.panel.add(this.content.getWidget(),  contentConstraints);

		this.panel.setMinimumSize(this.panel.getPreferredSize());

		this.content.whenShouldReload(() -> reloadParent());
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		this.content.refresh();
	}

}
