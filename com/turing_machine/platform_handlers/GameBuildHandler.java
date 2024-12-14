package com.turing_machine.platform_handlers;

import java.util.ArrayList;
import com.turing_machine.listeners.GameBuildProgressionListener;
import com.turing_machine.started_game.StartedGame;
import com.turing_machine.configuration.GameConfiguration;

public class GameBuildHandler {

	private GamePlayersBuilder players_starter;

	private GameMachineBuilder machine_starter;

	private ArrayList<GameBuildProgressionListener> listeners;

	public GameBuildHandler() {

	}

	public StartedGame startGameFromConfiguration(GameConfiguration configuration) {
		return null;
	}

	public void whenConfigurationProgress(GameBuildProgressionListener listener) {

	}

}
