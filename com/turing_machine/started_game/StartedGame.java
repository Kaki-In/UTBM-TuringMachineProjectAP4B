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

			ArrayList<StartedGamePlayer> minWinners = new ArrayList<>(); // ne pas oublier de prendre les joueurs avec le moins de vérification;

			if (players.getAlivePlayers().isEmpty() || !winning_players.isEmpty())
			{
				if (!winning_players.isEmpty())
				{
					int min_verif = winning_players.get(0).getNotes().getTestedCodesGrid().getTotalValidationsCount();

					for (StartedGamePlayer player: winning_players)
					{
						int verif_count = player.getNotes().getTestedCodesGrid().getTotalValidationsCount();

						if (verif_count < min_verif) { // il a encore moins que ce qu'on a pu trouver jusqu'alors
							minWinners = new ArrayList<>(); // les autres gagnants avaient plus et ne sont plus gagnant
							min_verif = verif_count; 		// maintenant, il faut avoir autant que lui pour être gagnant
						}

						if (verif_count == min_verif) // il a autant que les gagnants
						{
							minWinners.add(player);
						} 
					}
				}

				for (StartedGameListener listener: listeners)
				{
					listener.onGameEnds(minWinners);
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
