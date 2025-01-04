package com.turing_machine.started_game;

public class StartedGamePlayerNotes {

	private final StartedGamePlayerCriteria criteria;

	private final StartedGamePlayerNumbersGrid numbers;

	private final StartedGamePlayerTestedCodesGrid codes;

	public StartedGamePlayerNotes(StartedGamePlayerCriteria criteria, StartedGameState state) {
		this.criteria = criteria;
		this.numbers = new StartedGamePlayerNumbersGrid();
		this.codes = new StartedGamePlayerTestedCodesGrid(state);
	}

	public StartedGamePlayerNumbersGrid getNumbersGrid() {
		return this.numbers;
	}

	public StartedGamePlayerTestedCodesGrid getTestedCodesGrid() {
		return this.codes;
	}

	public StartedGamePlayerCriteria getCriteria() {
		return this.criteria;
	}

}
