package com.turing_machine.handlers;

import com.turing_machine.configuration.PlayerConfiguration;
import com.turing_machine.configuration.PlayersConfiguration;
import com.turing_machine.started_game.StartedGameMachine;
import com.turing_machine.started_game.StartedGamePlayer;
import com.turing_machine.started_game.StartedGamePlayersList;
import java.util.ArrayList;

public class GamePlayersBuilder {

	private final GamePlayerNotesBuilder notes_starter;

	public GamePlayersBuilder() {
		this.notes_starter = new GamePlayerNotesBuilder();
	}

	public StartedGamePlayersList exportPlayers(PlayersConfiguration configuration, StartedGameMachine machine) {
		ArrayList<StartedGamePlayer> players = new ArrayList<>();

		for (PlayerConfiguration player : configuration.getPlayers())
		{
			players.add(new StartedGamePlayer(player.getName(), this.notes_starter.createPlayerNotes(machine)));
		}

		return new StartedGamePlayersList(
			players
		);
	}
}
