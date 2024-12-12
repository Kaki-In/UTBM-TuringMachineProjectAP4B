package com.turring_machine.listeners;

import com.turring_machine.configuration.GameConfiguration;
import com.turring_machine.started_game.StartedGame;

public interface GameBuildProgressionListener {

	public abstract void onGameBuildStart(GameConfiguration configuration);

	public abstract void onGameBuildProgress(GameConfiguration configuration, double progress);

	public abstract void onGameBuildEnd(GameConfiguration configuration, StartedGame game);

}
