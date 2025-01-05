package com.turing_machine.views;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.platform_state.ConfiguratingGameStep;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameConfigurationPanel extends GameDisplayedPanel {

	private final GameConfiguration configuration;

	private final CodeConfigurationPanel code;

	private final PlayersConfigurationPanel players;

	private final JPanel panel;
	
	private final JButton startButton;

	public GameConfigurationPanel(ConfiguratingGameStep configuration) {
		super(configuration);

		this.configuration = configuration.getGameConfiguration();

		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());

		GridBagConstraints titleConstraints = new GridBagConstraints();
		titleConstraints.gridx = 0;
		titleConstraints.gridy = 0;
		titleConstraints.gridwidth = 3;
		titleConstraints.gridheight = 1;
		titleConstraints.fill = GridBagConstraints.VERTICAL;
		titleConstraints.anchor = GridBagConstraints.CENTER;
		titleConstraints.weighty = 1;

		JLabel title_label = new JLabel("Configuration de la partie");
		title_label.setFont(Displayable.getFont(30));
		this.panel.add(title_label, titleConstraints);

		GridBagConstraints codeConstraints = new GridBagConstraints();
		codeConstraints.gridx = 0;
		codeConstraints.gridy = 1;
		codeConstraints.gridwidth = 1;
		codeConstraints.gridheight = 1;
		codeConstraints.fill = GridBagConstraints.HORIZONTAL;
		codeConstraints.anchor = GridBagConstraints.NORTH;
		codeConstraints.weightx = 1;

		this.code = new CodeConfigurationPanel(this.configuration.getCodeConfiguration());
		this.panel.add(this.code.getWidget(), codeConstraints);
		
		GridBagConstraints spaceConstraints = new GridBagConstraints();
		spaceConstraints.gridx = 1;
		spaceConstraints.gridy = 1;
		spaceConstraints.gridwidth = 1;
		spaceConstraints.gridheight = 1;
		spaceConstraints.fill = GridBagConstraints.HORIZONTAL;
		spaceConstraints.anchor = GridBagConstraints.NORTH;
		spaceConstraints.weightx = 0;

		JPanel space_panel = new JPanel();
		space_panel.setSize(1, 20);
		this.panel.add(space_panel, spaceConstraints);

		GridBagConstraints playersConstraint = new GridBagConstraints();
		playersConstraint.gridx = 2;
		playersConstraint.gridy = 1;
		playersConstraint.gridwidth = 1;
		playersConstraint.gridheight = 1;
		playersConstraint.fill = GridBagConstraints.HORIZONTAL;
		playersConstraint.anchor = GridBagConstraints.NORTH;
		playersConstraint.weightx = 1;

		this.players = new PlayersConfigurationPanel(this.configuration.getPlayersConfiguration());
		this.panel.add(this.players.getWidget(), playersConstraint);
		
		GridBagConstraints buttonConstraint = new GridBagConstraints();
		buttonConstraint.gridx = 0;
		buttonConstraint.gridy = 2;
		buttonConstraint.gridwidth = 3;
		buttonConstraint.gridheight = 1;
		buttonConstraint.fill = GridBagConstraints.VERTICAL;
		buttonConstraint.anchor = GridBagConstraints.CENTER;

		this.startButton = new JButton("Démarrer la partie");
		this.panel.add(this.startButton, buttonConstraint);

		this.startButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				if (!configuration.getGameConfiguration().isReady()) return;

				configuration.startGame();
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

		this.code.whenShouldReload(() -> this.reloadParent());
		this.players.whenShouldReload(() -> this.reloadParent());

		this.startButton.setEnabled(this.configuration.isReady());

		this.panel.setPreferredSize(new Dimension(500, 300));
	}

	@Override
	public JComponent getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
		this.startButton.setEnabled(this.configuration.isReady());
		this.code.refresh();
		this.players.refresh();
	}

}
