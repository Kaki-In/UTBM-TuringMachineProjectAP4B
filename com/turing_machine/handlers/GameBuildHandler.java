package com.turing_machine.handlers;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.exceptions.NotReadyConfigurationException;
import com.turing_machine.exceptions.TuringMachineAPIException;
import com.turing_machine.listeners.GameBuildProgressionListener;
import com.turing_machine.platform_state.BuildGameStep;
import com.turing_machine.platform_state.ConfiguratingGameStep;
import com.turing_machine.platform_state.MainPlatformState;
import com.turing_machine.platform_state.StartedGameStep;
import com.turing_machine.started_game.StartedGame;
import com.turing_machine.started_game.StartedGameMachine;
import com.turing_machine.started_game.StartedGamePlayersList;
import java.util.ArrayList;

public class GameBuildHandler extends PlatformHandler {

	private final GamePlayersBuilder players_starter;

	private final GameMachineBuilder machine_starter;

	private final ArrayList<GameBuildProgressionListener> listeners;

	public GameBuildHandler(MainPlatformState state) {
		super(state);

		this.players_starter = new GamePlayersBuilder();
		this.machine_starter = new GameMachineBuilder();
		this.listeners = new ArrayList<>();

		state.whenPlatformStepChanged((last_step, new_step) -> {
			if (new_step instanceof BuildGameStep buildGameStep)
			{
				GameConfiguration configuration = buildGameStep.getGameConfiguration();

				try {
					StartedGame game = this.startGameFromConfiguration(configuration);
					state.setActualStep(new StartedGameStep(game));
				} catch (TuringMachineAPIException | NotReadyConfigurationException e) {
					for (GameBuildProgressionListener listener: this.listeners)
					{
						listener.onGameBuildError(configuration, e.getMessage());
					}

					state.setActualStep(new ConfiguratingGameStep(configuration));
				}
			}
		});
	}

	public StartedGame startGameFromConfiguration(GameConfiguration configuration) throws TuringMachineAPIException, NotReadyConfigurationException {
		if (!configuration.isReady())
		{
			throw new NotReadyConfigurationException();
		}

		for (GameBuildProgressionListener listener: this.listeners)
		{
			listener.onGameBuildStart(configuration);
		}

		for (GameBuildProgressionListener listener: this.listeners)
		{
			listener.onGameBuildProgress(configuration, 0/3, "Création de la machine...");
		}

		StartedGameMachine machine = this.machine_starter.exportMachine(configuration.getCodeConfiguration());

		for (GameBuildProgressionListener listener: this.listeners)
		{
			listener.onGameBuildProgress(configuration, 1/3, "Création des joueurs...");
		}

		StartedGamePlayersList players = this.players_starter.exportPlayers(configuration.getPlayersConfiguration(), machine);

		for (GameBuildProgressionListener listener: this.listeners)
		{
			listener.onGameBuildProgress(configuration, 2/3, "Création de la partie...");
		}

		StartedGame game = new StartedGame(machine, players);

		for (GameBuildProgressionListener listener: this.listeners)
		{
			listener.onGameBuildProgress(configuration, 3/3, "Démarrage de la partie...");
		}

		for (GameBuildProgressionListener listener: this.listeners)
		{
			listener.onGameBuildEnd(configuration, game);
		}

		return game;
	}

	public void whenConfigurationProgress(GameBuildProgressionListener listener) {
		this.listeners.add(listener);
	}

}
