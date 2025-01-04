package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;
import com.turing_machine.listeners.StartedGameListener;
import java.util.ArrayList;

public class StartedGame {

	private int round_id;

	private final ArrayList<StartedGameListener> listeners;

	private final StartedGameMachine machine;
	
	private final StartedGamePlayersList players;

	public StartedGame(StartedGameMachine machine, StartedGamePlayersList players) {

		this.machine = machine;
        this.players = players;
        this.listeners = new ArrayList<>();
        this.round_id = 0; 
	}

	public int getActualRoundId() {
		return round_id;
	}

	public StartedGameMachine getMachine() {
		return machine;
	}

	public StartedGamePlayersList getPlayersList() {
		return players;
	}

	public void endRound() {
		ArrayList<String> guessing_players = this.players.getHypothesingPlayersNames();
		ArrayList<StartedGamePlayer> winning_players = new ArrayList();

		for (String player_name: guessing_players)
		{
			StartedGamePlayer player = this.players.getPlayerByName(player_name);
			
			Code code = player.getGuessingCode();

			if (code == null) continue;

			if (code.equals(this.machine.getCode()))
			{
				winning_players.add(player);
			} else {
				player.eliminate();
			}
		}

		if (winning_players.isEmpty())
		{
			++this.round_id;

			for (String player_name: this.players.getPlayersNames())
			{
				StartedGamePlayer player = this.players.getPlayerByName(player_name);

				player.getNotes().getTestedCodesGrid().addNewLine();
			}

			for (StartedGameListener listener : this.listeners)
			{
				listener.onNewRound(this.round_id);
			}
		} else {
			for (StartedGameListener listener : this.listeners)
			{
				listener.onGameEnds(winning_players);
			}
		}

	}

	public void whenRoundChanged(StartedGameListener listener)
	{
		this.listeners.add(listener);
	}

}
