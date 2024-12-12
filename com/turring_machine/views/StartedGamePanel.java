package com.turring_machine.views;

import java.util.ArrayList;
import com.turring_machine.started_game.StartedGame;
import com.turring_machine.platform_state.StartedGameStep;

public class StartedGamePanel extends GameDisplayedPanel implements Displayable {

	private ArrayList<Runnable> end_round_listeners;

	private StartedGame game;

	private StartedGameMachinePanel machine;

	private StartedGamePlayersPanel players;

	public StartedGamePanel(StartedGameStep game) {

	}

	public void whenRoundEndLaunched(Runnable listener) {

	}

}
