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
		// On commence d'abord par vérifier qu'aucun joueur n'a le même nom
		for (int player_index=0 ;  player_index < this.size() - 1; ++player_index)
		{
			PlayerConfiguration player = this.getPlayer(player_index);

			for (int second_player_index=player_index + 1 ;  player_index < this.size(); ++player_index)
			{
				PlayerConfiguration second_player = this.getPlayer(player_index);

				if (player.getName().equals(second_player.getName()))
				{
					return false;
				}
			}
		}

		// Si tout c'est bien passé, alors la configuration est prête
		return true;
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
		this.players.remove(player_id);
	}

	public ArrayList<PlayerConfiguration> getPlayers() {
		return players;
	}

	public PlayerConfiguration getPlayer(int player_id) {
		return this.players.get(player_id);
	}

	public int size() {
		return this.players.size();
	}

	public void whenPlayersListModified(ObjectsListChangeListener<PlayerConfiguration> listener) {
		players_listeners.add(listener);
	}

}
