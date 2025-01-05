package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;
import com.turing_machine.listeners.StartedGameListener;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class StartedGame {

	private final StartedGamePlayersList players;

	private final StartedGameState state;

	private final ArrayList<StartedGameListener> listeners;

	public StartedGame(StartedGameMachine machine, StartedGamePlayersList players, StartedGameState game_state) {
		
		this.state = game_state;
        this.players = players;

		this.listeners = new ArrayList<>();

		this.state.whenRoundChanged(round_id -> {
			ArrayList<StartedGamePlayer> guessing_players = players.getHypothesingPlayers();

			ArrayList<StartedGamePlayer> winning_players = guessing_players.stream().filter(player -> {
				Code code = player.getGuessingCode();

				if (code == null) return false; // serait illogique mais possible

				if (code.equals(machine.getCode()))
				{
					return true;
				} else {
					player.eliminate();
					return false;
				}

			}).collect(Collectors.toCollection(ArrayList::new));

			if (players.getAlivePlayers().isEmpty() || !winning_players.isEmpty())
			{
				for (StartedGameListener listener: listeners)
				{
					listener.onGameEnds(winning_players);
				}
			}
		});
	}

	public StartedGameState getState()
	{
		return this.state;
	}

	public StartedGamePlayersList getPlayersList() {
		return players;
	}

	public void whenGameEnds(StartedGameListener listener)
	{
		this.listeners.add(listener);
	}

}
