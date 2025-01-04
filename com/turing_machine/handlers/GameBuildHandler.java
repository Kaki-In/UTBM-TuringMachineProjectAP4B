package com.turing_machine.handlers;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.exceptions.NotReadyConfigurationException;
import com.turing_machine.exceptions.TuringMachineAPIException;
import com.turing_machine.platform_state.BuildGameStep;
import com.turing_machine.platform_state.ConfiguratingGameStep;
import com.turing_machine.platform_state.MainPlatformState;
import com.turing_machine.platform_state.StartedGameStep;
import com.turing_machine.started_game.StartedGame;
import com.turing_machine.started_game.StartedGameMachine;
import com.turing_machine.started_game.StartedGamePlayersList;
import com.turing_machine.started_game.StartedGameState;

public class GameBuildHandler extends PlatformHandler {

	private final GamePlayersBuilder players_starter;

	private final GameMachineBuilder machine_starter;

	public GameBuildHandler(MainPlatformState state) {
		super(state);

		this.players_starter = new GamePlayersBuilder();
		this.machine_starter = new GameMachineBuilder();

		state.whenPlatformStepChanged((last_step, new_step) -> {
			if (new_step instanceof BuildGameStep buildGameStep)
			{
				GameConfiguration configuration = buildGameStep.getGameConfiguration();

				new Thread(() -> {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						return;
					}
					try {
						StartedGame game = this.startGameFromConfiguration(configuration);
						state.setActualStep(new StartedGameStep(game));
					} catch (TuringMachineAPIException | NotReadyConfigurationException e) {
						buildGameStep.emitConfigurationError(e.getMessage());
						state.setActualStep(new ConfiguratingGameStep(configuration));
					}
				}).start();

			}
		});
	}

	public StartedGame startGameFromConfiguration(GameConfiguration configuration) throws TuringMachineAPIException, NotReadyConfigurationException {
		MainPlatformState state = this.getState();

		if (!(state.getActualStep() instanceof BuildGameStep buildGameStep))
		{
			throw new NotReadyConfigurationException();
		}

		if (!configuration.isReady())
		{
			throw new NotReadyConfigurationException();
		}

		buildGameStep.emitConfigurationStart();

		buildGameStep.emitConfigurationProgress((float) 0., "Création de la machine...");

		StartedGameMachine machine = this.machine_starter.exportMachine(configuration.getCodeConfiguration());
		StartedGameState game_state = new StartedGameState(machine);

		buildGameStep.emitConfigurationProgress((float) 0.50, "Création des joueurs...");

		StartedGamePlayersList players = this.players_starter.exportPlayers(configuration.getPlayersConfiguration(), game_state);

		buildGameStep.emitConfigurationProgress((float) 0.75, "Création du jeu...");

		StartedGame game = new StartedGame(machine, players, game_state);

		buildGameStep.emitConfigurationProgress(1, "Démarrage de la partie...");

		buildGameStep.emitConfigurationEnd(game);

		return game;
	}

}
