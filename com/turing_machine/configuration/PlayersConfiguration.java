package com.turing_machine.configuration;

import com.turing_machine.listeners.ObjectsListChangeListener;
import java.util.ArrayList;

public class PlayersConfiguration implements Configurable {

	private final ArrayList<ObjectsListChangeListener<PlayerConfiguration>> players_listeners;

	private final ArrayList<PlayerConfiguration> players;

	public PlayersConfiguration() {

		this.players_listeners = new ArrayList<>();
        this.players = new ArrayList<>();
	}

	@Override
	public boolean isReady()
	{
		if (this.players.isEmpty()) return false;

		// On commence d'abord par vérifier qu'aucun joueur n'a le même nom
		for (int player_index=0 ;  player_index < this.size(); ++player_index)
		{
			PlayerConfiguration player = this.getPlayer(player_index);

			// on vérifie que le joueur est prêt
			if (!player.isReady()) return false; 

			// et on vérifie qu'aucun autre joueur n'a le même nom
			for (int second_player_index = player_index + 1 ;  second_player_index < this.size(); ++second_player_index)
			{
				PlayerConfiguration second_player = this.getPlayer(second_player_index);

				if (player.getName().equals(second_player.getName()))
				{
					return false;
				}
			}
		}

		// Si tout s'est bien passé, alors la configuration est prête
		return true;
	}

	public void addPlayer() {
		// On commence par chercher un nom qui soit différents des autres
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

		// et on crée le joueur avec ce nom pour le rajouter à la liste
		PlayerConfiguration newPlayer = new PlayerConfiguration("Joueur " + name_int);

        players.add(newPlayer);

		for (ObjectsListChangeListener<PlayerConfiguration> listener : this.players_listeners)
		{
			listener.onObjectAdded(newPlayer, this.players);
		}
	}

	public void removePlayer(int player_id) {
		PlayerConfiguration player = getPlayer(player_id);

		this.players.remove(player_id);

		for (ObjectsListChangeListener<PlayerConfiguration> listener : this.players_listeners)
		{
			listener.onObjectDeleted(player, this.players);
		}
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
