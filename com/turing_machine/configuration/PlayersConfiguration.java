package com.turing_machine.configuration;

import com.turing_machine.listeners.ObjectsListChangeListener;
import java.util.ArrayList;

public class PlayersConfiguration implements Configurable {

	private ArrayList<ObjectsListChangeListener<PlayerConfiguration>> players_listeners;

	private ArrayList<PlayerConfiguration> players;

	public PlayersConfiguration() {

		this.players_listeners = new ArrayList<>();
        this.players = new ArrayList<>();
	}

	@Override
	public boolean isReady()
	{
		return false;
	}

	public void addPlayer() {
		int name_int = 0;
		boolean can_use_name;

		do
		{
			++name_int;
			can_use_name = true;

			for (int i=0; i < this.players.size(); ++i)
			{
				PlayerConfiguration player = this.players.get(i);

				if (player.getName().equals("Joueur " + name_int))
				{
					can_use_name = false;
					break;
				}
			}
		} while (!can_use_name);

		PlayerConfiguration newPlayer = new PlayerConfiguration("Joueur " + name_int);

        players.add(newPlayer);

		for (ObjectsListChangeListener<PlayerConfiguration> listener : this.players_listeners)
		{
			listener.onObjectAdded(newPlayer, this.players);
		}
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
		return this.players.get(player_id);
	}

	public int size() {
		return 0;
	}

	public void whenPlayersListModified(ObjectsListChangeListener<PlayerConfiguration> listener) {
		players_listeners.add(listener);
	}

}
