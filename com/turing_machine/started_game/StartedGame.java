package com.turing_machine.started_game;

import com.turing_machine.listeners.StartedGameListener;
import java.util.ArrayList;

public class StartedGame {

	private int round_id;

	private ArrayList<StartedGameListener> listeners;

	private StartedGameMachine machine;
	
	private StartedGamePlayersList players;

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

	}

	public void whenRoundChanged(StartedGameListener listener)
	{
		this.round_listeners.add(listener);

		for (ObjectsListChangeListener<StartedGame> listener : this.listeners)
		{
			listener.onObjectChanged(listener, this.listeners);
		}

	}

}
