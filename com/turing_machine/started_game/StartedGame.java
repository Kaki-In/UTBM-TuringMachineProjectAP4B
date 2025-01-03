package com.turing_machine.started_game;

import com.turing_machine.listeners.StartedGameListener;
import java.util.ArrayList;

public class StartedGame {

	private int round_id;

	private ArrayList<StartedGameListener> listeners;

	private StartedGameMachine machine;
	
	private StartedGamePlayersList players;

	public StartedGame(StartedGameMachine machine, StartedGamePlayersList players) {

	}

	public int getActualRoundId() {
		return 0;
	}

	public StartedGameMachine getMachine() {
		return null;
	}

	public StartedGamePlayersList getPlayersList() {
		return null;
	}

	public void endRound() {

	}

	public void whenRoundChanged(StartedGameListener listener)
	{
		
	}

}
