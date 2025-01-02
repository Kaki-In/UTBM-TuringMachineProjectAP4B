package com.turing_machine.platform_state;

import com.turing_machine.started_game.StartedGameMachine;
import com.turing_machine.started_game.StartedGamePlayer;
import java.util.ArrayList;

public class GameDebriefingStep extends PlatformStep {

	private final ArrayList<StartedGamePlayer> winners;

	private final StartedGameMachine machine;

	public GameDebriefingStep(ArrayList<StartedGamePlayer> winners, StartedGameMachine machine) {
		this.winners = winners;
		this.machine = machine;
	}

	public ArrayList<StartedGamePlayer> getWinners() {
		return this.winners;
	}

	public StartedGameMachine getMachine() {
		return this.machine;
	}

}
