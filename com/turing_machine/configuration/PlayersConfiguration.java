package com.turing_machine.configuration;

import java.util.ArrayList;
import com.turing_machine.listeners.ObjectsListChangeListener;

public class PlayersConfiguration implements Configurable {

	private ArrayList<ObjectsListChangeListener<PlayerConfiguration>> players_listeners;

	private ArrayList<PlayerConfiguration> players;

	public PlayersConfiguration() {

	}

	public void addPlayer() {

	}

	public void removePlayer(String player_name) {

	}

	public ArrayList<PlayerConfiguration> getPlayers() {
		return null;
	}

	public PlayerConfiguration getPlayer(String player_name) {
		return null;
	}

	public void whenPlayersListModified(ObjectsListChangeListener<PlayerConfiguration> listener) {

	}

}
