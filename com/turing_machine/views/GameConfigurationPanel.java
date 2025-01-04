package com.turing_machine.views;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.configuration.PlayerConfiguration;
import com.turing_machine.platform_state.ConfiguratingGameStep;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
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
		titleConstraints.gridwidth = 2;
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
		codeConstraints.fill = GridBagConstraints.BOTH;
		titleConstraints.weightx = 1;
		titleConstraints.weighty = 3;

		this.code = new CodeConfigurationPanel(this.configuration.getCodeConfiguration());
		this.panel.add(this.code.getWidget(), codeConstraints);
		
		GridBagConstraints playersConstraint = new GridBagConstraints();
		playersConstraint.gridx = 1;
		playersConstraint.gridy = 1;
		playersConstraint.gridwidth = 1;
		playersConstraint.gridheight = 1;
		playersConstraint.fill = GridBagConstraints.BOTH;
		titleConstraints.weightx = 1;
		titleConstraints.weighty = 3;

		this.players = new PlayersConfigurationPanel(this.configuration.getPlayersConfiguration());
		this.panel.add(this.players.getWidget(), playersConstraint);
		
		GridBagConstraints buttonConstraint = new GridBagConstraints();
		buttonConstraint.gridx = 0;
		buttonConstraint.gridy = 2;
		buttonConstraint.gridwidth = 2;
		buttonConstraint.gridheight = 1;
		buttonConstraint.fill = GridBagConstraints.VERTICAL;
		buttonConstraint.anchor = GridBagConstraints.CENTER;

		this.startButton = new JButton("Démarrer la partie");
		this.panel.add(this.startButton, buttonConstraint);

		this.startButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
				System.out.println("Difficulté " + configuration.getGameConfiguration().getCodeConfiguration().getGameDifficulty());
				System.out.println("Nombre de critères " + configuration.getGameConfiguration().getCodeConfiguration().getCriteriaCount());
				System.out.println("Utilisez l'API " + configuration.getGameConfiguration().getCodeConfiguration().getUsesApi());

				System.out.println();
				System.out.println("Joueurs");

				for (PlayerConfiguration player: configuration.getGameConfiguration().getPlayersConfiguration().getPlayers())
				{
					System.out.println(player.getName());
				}

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

		configuration.getGameConfiguration().getCodeConfiguration().whenCriteriaCountChanged((l,n) -> {this.reloadParent();});
		configuration.getGameConfiguration().getCodeConfiguration().whenGameDifficultyChanged((l,n) -> {this.reloadParent();});
		configuration.getGameConfiguration().getCodeConfiguration().whenUsesApiChanged((l,n) -> {this.reloadParent();});

		this.startButton.setEnabled(this.configuration.isReady());
	}

	@Override
	public Component getWidget()
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
