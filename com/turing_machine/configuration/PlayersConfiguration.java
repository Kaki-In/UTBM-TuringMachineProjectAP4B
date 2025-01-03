package com.turing_machine.configuration;

import com.turing_machine.listeners.ObjectsListChangeListener;
import java.util.ArrayList;

public class PlayersConfiguration implements Configurable {

	private ArrayList<ObjectsListChangeListener<PlayerConfiguration>> players_listeners;

	private ArrayList<PlayerConfiguration> players;

	public PlayersConfiguration() {

		this.playersListener = new ArrayList<>();
        this.players = new ArrayList<>();
	}

	@Override
	public boolean isReady()
	{
		return false;
	}

	public void addPlayer() {

		PlayerConfiguration newPlayer = new PlayerConfiguration();
        players.add(newPlayer);
        

	}

	public void removePlayer(int player_id) {

		If(player -> player.getId() == playerId){
			players.remove(player_id);
		}
    

	}

	public ArrayList<PlayerConfiguration> getPlayers() {
		return new ArrayList<>(players);
	}

	public PlayerConfiguration getPlayer(int player_id) {
		for (PlayerConfiguration player : players) {
            if (player.getId() == playerId) {
                return player;
            }
        }
        return null; // if the player isn't find
	}

	public int size() {
		return 0;
	}

	public void whenPlayersListModified(ObjectsListChangeListener<PlayerConfiguration> listener) {
		playersListener.add(listener);
	}

}
