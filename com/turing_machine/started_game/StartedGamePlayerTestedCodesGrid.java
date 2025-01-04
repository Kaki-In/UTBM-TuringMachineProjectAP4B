package com.turing_machine.started_game;

import com.turing_machine.listeners.ObjectSelectionListener;
import java.util.ArrayList;

public class StartedGamePlayerTestedCodesGrid {

	private final ArrayList<ObjectSelectionListener<StartedGamePlayerTestedCodesLine>> rounds_listener;

	private final ArrayList<StartedGamePlayerTestedCodesLine> lines;

	private final StartedGameState state;

	public StartedGamePlayerTestedCodesGrid(StartedGameState state) {
		this.rounds_listener = new ArrayList<>();
		this.lines = new ArrayList<>();
		this.state = state;

	}

	public StartedGamePlayerTestedCodesLine getLineFromRound(int round_id) {
		return this.lines.get(round_id);
	}

	public int getTotalValidationsCount() {
		return this.lines.stream().map(line -> line.getValidationsCount()).reduce(0, (t1, count) -> t1 + count);
	}

	protected void addNewLine() {
		StartedGamePlayerTestedCodesLine line = new StartedGamePlayerTestedCodesLine(state);
		this.lines.add(line);

		for (ObjectSelectionListener<StartedGamePlayerTestedCodesLine> listener: this.rounds_listener)
		{
			listener.onObjectSelected(line);
		}
	}

	public void whenNewLine(ObjectSelectionListener<StartedGamePlayerTestedCodesLine> listener) {
		this.rounds_listener.add(listener);
	}

}
