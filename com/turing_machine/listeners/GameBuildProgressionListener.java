package com.turing_machine.listeners;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.started_game.StartedGame;

public interface GameBuildProgressionListener {

	public abstract void onGameBuildStart(GameConfiguration configuration);

	public abstract void onGameBuildProgress(GameConfiguration configuration, float progress, String message);

	public abstract void onGameBuildEnd(GameConfiguration configuration, StartedGame game);

	public abstract void onGameBuildError(GameConfiguration configuration, String reasong);

}
