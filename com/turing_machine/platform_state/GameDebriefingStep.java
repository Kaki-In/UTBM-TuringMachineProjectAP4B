package com.turing_machine.platform_state;

import com.turing_machine.started_game.StartedGameMachine;
import com.turing_machine.started_game.StartedGamePlayer;
import java.util.ArrayList;

public class GameDebriefingStep extends PlatformStep {

	private final ArrayList<Runnable> listeners;

	private final ArrayList<StartedGamePlayer> winners;

	private final StartedGameMachine machine;

	public GameDebriefingStep(ArrayList<StartedGamePlayer> winners, StartedGameMachine machine) {
		this.listeners = new ArrayList<>();

		this.winners = winners;
		this.machine = machine;
	}

	public void playAgain()
	{
		for (Runnable listener: this.listeners)
		{
			listener.run();
		}
	}

	public ArrayList<StartedGamePlayer> getWinners() {
		return this.winners;
	}

	public StartedGameMachine getMachine() {
		return this.machine;
	}

	public void whenRestartLaunched(Runnable listener)
	{
		this.listeners.add(listener);
	}

}
