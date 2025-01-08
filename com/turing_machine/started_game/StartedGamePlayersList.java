package com.turing_machine.started_game;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StartedGamePlayersList {

	private final ArrayList<StartedGamePlayer> players;

	public StartedGamePlayersList(ArrayList<StartedGamePlayer> players) {
		this.players = players;
	}

	public ArrayList<String> getPlayersNames() {
		return this.players.stream().map(player -> player.getName()).collect(Collectors.toCollection(ArrayList::new));
	}

	public StartedGamePlayer getPlayerByName(String name) {
		for (StartedGamePlayer player: this.players)
		{
			if (player.getName().equals(name))
			{
				return player;
			}
		}

		return null;
	}

	public ArrayList<StartedGamePlayer> getEnabledPlayers() {
		return this.players.stream().filter(player -> !player.isDisabled()).collect(Collectors.toCollection(ArrayList::new));
	}

	public ArrayList<StartedGamePlayer> getAlivePlayers() {
		return this.players.stream().filter(player -> !player.isEliminated()).collect(Collectors.toCollection(ArrayList::new));
	}

	public ArrayList<StartedGamePlayer> getHypothesingPlayers() {
		return this.players.stream().filter(player -> player.isGuessingACode() && !player.isEliminated()).collect(Collectors.toCollection(ArrayList::new));
	}

}
