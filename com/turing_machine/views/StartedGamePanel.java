package com.turing_machine.views;

import com.turing_machine.platform_state.StartedGameStep;
import com.turing_machine.started_game.StartedGame;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGamePanel extends GameDisplayedPanel implements Displayable {

	private ArrayList<Runnable> end_round_listeners;

	private StartedGame game;

	private StartedGameMachinePanel machine;

	private StartedGamePlayersPanel players;

	public StartedGamePanel(StartedGameStep game) {
		super(game);
	}

	public void whenRoundEndLaunched(Runnable listener) {

	}

	@Override
	public Component getWidget()
	{
		return null;
	}

	@Override
	public void refresh()
	{
	}

}
