package com.turing_machine.started_game;

import com.turing_machine.listeners.ObjectSelectionListener;
import java.util.ArrayList;

public class StartedGamePlayerTestedCodesGrid {

	private final ArrayList<ObjectSelectionListener<StartedGamePlayerTestedCodesLine>> rounds_listener;

	private final ArrayList<StartedGamePlayerTestedCodesLine> lines;

	private final StartedGameState state;

	private boolean disabled ;

	public StartedGamePlayerTestedCodesGrid(StartedGameState state) {
		this.rounds_listener = new ArrayList<>();
		this.lines = new ArrayList<>();
		this.state = state;

		this.disabled = false;

		this.state.whenRoundChanged((round_id) -> {
			this.addNewLine(round_id);
		});

		this.addNewLine(0);
	}

	public StartedGamePlayerTestedCodesLine getLineFromRound(int round_id) {
		return this.lines.get(round_id);
	}

	public int getTotalValidationsCount() {
		return this.lines.stream().map(line -> line.getValidationsCount()).reduce(0, (t1, count) -> t1 + count);
	}

	protected void addNewLine(int round) {
		StartedGamePlayerTestedCodesLine line = new StartedGamePlayerTestedCodesLine(state, round);
		this.lines.add(line);

		for (ObjectSelectionListener<StartedGamePlayerTestedCodesLine> listener: this.rounds_listener)
		{
			listener.onObjectSelected(line);
		}
	}

	public StartedGameState getState()
	{
		return this.state;
	}

	public void disable()
	{
		this.disabled = true;
	}

	public boolean isDisabled()
	{
		return this.disabled;
	}

	public void whenNewLine(ObjectSelectionListener<StartedGamePlayerTestedCodesLine> listener) {
		this.rounds_listener.add(listener);
	}

}
