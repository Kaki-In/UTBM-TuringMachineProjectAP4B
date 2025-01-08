package com.turing_machine.handlers;

import com.turing_machine.api.TuringMachineAPI;
import com.turing_machine.api.TuringMachineGeneratedConfiguration;
import com.turing_machine.configuration.MachineConfiguration;
import com.turing_machine.database.Database;
import com.turing_machine.database.DefaultGame;
import com.turing_machine.exceptions.NoSuchGameException;
import com.turing_machine.exceptions.TuringMachineAPIException;
import com.turing_machine.started_game.StartedGameCriteriaList;
import com.turing_machine.started_game.StartedGameCriterion;
import com.turing_machine.started_game.StartedGameMachine;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GameMachineBuilder {

	private final TuringMachineAPI api;

	public GameMachineBuilder()
	{
		this.api = new TuringMachineAPI("turingmachine.info");
	}

	public StartedGameMachine exportMachine(MachineConfiguration code_configuration) throws TuringMachineAPIException, NoSuchGameException
	{
		if (code_configuration.getUsesApi())
			return exportMachineWithAPI(code_configuration);
		else
			return exportMachineWithoutAPI(code_configuration);
	}

	public StartedGameMachine exportMachineWithAPI(MachineConfiguration code_configuration) throws TuringMachineAPIException {
		TuringMachineGeneratedConfiguration configuration = api.generateGameConfiguration(code_configuration.getGameDifficulty(), code_configuration.getCriteriaCount());			

		StartedGameCriteriaList criteria = new StartedGameCriteriaList(
			configuration.getCriteria()
				.stream()
				.map(
					criterion -> new StartedGameCriterion(criterion.getId(), criterion.getLetter(), criterion.getGoodCase())
				).collect(Collectors.toCollection(ArrayList::new))
		);

		return new StartedGameMachine(configuration.getCode(), criteria);
	}

	public StartedGameMachine exportMachineWithoutAPI(MachineConfiguration code_configuration) throws NoSuchGameException {
		DefaultGame game = Database.getDefaultGames().getRandomGame(code_configuration.getGameDifficulty(), code_configuration.getCriteriaCount());

		StartedGameCriteriaList criteria = new StartedGameCriteriaList(
			game.getCriteria()
				.stream()
				.map(
					criterion -> new StartedGameCriterion(criterion.getId(), criterion.getLetter(), criterion.getGoodCase())
				).collect(Collectors.toCollection(ArrayList::new))
		);

		return new StartedGameMachine(game.getCode(), criteria);
	}

}
