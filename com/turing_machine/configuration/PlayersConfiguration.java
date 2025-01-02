package com.turing_machine.configuration;

import com.turing_machine.listeners.ObjectsListChangeListener;
import java.util.ArrayList;

public class PlayersConfiguration implements Configurable {

	private ArrayList<ObjectsListChangeListener<PlayerConfiguration>> players_listeners;

	private ArrayList<PlayerConfiguration> players;

	public PlayersConfiguration() {

	}

	@Override
	public boolean isReady()
	{
		return false;
	}

	public void addPlayer() {

	}

	public void removePlayer(int player_id) {

	}

	public ArrayList<PlayerConfiguration> getPlayers() {
		return null;
	}

	public PlayerConfiguration getPlayer(int player_id) {
		return null;
	}

	public int size() {
		return 0;
	}

	public void whenPlayersListModified(ObjectsListChangeListener<PlayerConfiguration> listener) {

	}

}
