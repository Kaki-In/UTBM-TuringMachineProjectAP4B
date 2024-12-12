package com.turring_machine.platform_handlers;

import com.turring_machine.listeners.GameBuildProgressionListener;
import com.turring_machine.started_game.StartedGame;
import com.turring_machine.configuration.GameConfiguration;

public class GameBuildHandler {

	private GamePlayersBuilder players_starter;

	private GameMachineBuild machine_starter;

	private ArrayList<GameBuildProgressionListener> listeners;

	public GameBuildHandler() {

	}

	public StartedGame startGameFromConfiguration(GameConfiguration configuration) {
		return null;
	}

	public void whenConfigurationProgress(GameBuildProgressionListener listener) {

	}

}
