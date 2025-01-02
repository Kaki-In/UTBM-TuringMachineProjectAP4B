package com.turing_machine.platform_state;

import com.turing_machine.started_game.StartedGame;

public class StartedGameStep extends PlatformStep {

	private final StartedGame game;

	public StartedGameStep(StartedGame game) {
		this.game = game;
	}

	public StartedGame getStartedGame() {
		return this.game;
	}

}
