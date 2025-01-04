package com.turing_machine.views;

import com.turing_machine.platform_state.StartedGameStep;
import com.turing_machine.started_game.StartedGame;
import java.awt.Component;
import javax.swing.JPanel;

public class StartedGamePanel extends GameDisplayedPanel {

	private StartedGame game;

	private StartedGameMachinePanel machine;

	private StartedGamePlayersPanel players;

	private JPanel panel;

	public StartedGamePanel(StartedGameStep game) {
		super(game);

		this.panel = new JPanel();
	}

	@Override
	public Component getWidget()
	{
		return this.panel;
	}

	@Override
	public void refresh()
	{
	}

}
