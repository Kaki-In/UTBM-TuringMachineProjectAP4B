package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;
import com.turing_machine.listeners.StartedGameCodesLineListener;
import com.turing_machine.listeners.StartedGamePlayerEventsListener;
import java.util.ArrayList;

public class StartedGamePlayer {

	private final String name;

	private final ArrayList<StartedGamePlayerEventsListener> listeners;

	private final StartedGamePlayerNotes notes;

	private Code actual_hypothesis;

	private boolean eliminated;

	private final StartedGameState state;

	public StartedGamePlayer(String name, StartedGamePlayerNotes notes, StartedGameState game_state) {
		this.name = name;
		this.listeners = new ArrayList<>();

		this.notes = notes;
		this.actual_hypothesis = null;
		this.eliminated = false;

		this.state = game_state;

		this.notes.getTestedCodesGrid().whenNewLine(line -> {
			line.whenNewValidation(new StartedGameCodesLineListener() {
				@Override
				public void onCodeDecided(Code code) {}

				@Override
				public void onVerificationDone(StartedGamePlayerTestedCodeValidationResult result) {
					if (line.getValidationsCount() == 3) // in this case, the player becomes disabled and should announce it
					{
						for (StartedGamePlayerEventsListener listener: listeners)
						{
							listener.onPlayerDisabled();
						}
					}
				}
	
			});
		});
	}

	public String getName() {
		return this.name;
	}

	public boolean isDisabled() {
		return this.eliminated
			|| this.notes.getTestedCodesGrid().getLineFromRound(this.state.getRoundId()).getValidationsCount() >= 3
			|| this.isGuessingACode();
	}

	public boolean isEliminated() {
		return this.eliminated;
	}

	public boolean isGuessingACode() {
		return this.actual_hypothesis != null;
	}

	public Code getGuessingCode() {
		return this.actual_hypothesis;
	}

	public StartedGamePlayerNotes getNotes(){
		return this.notes;
	}

	public void guessCode(Code code)
	{
		this.actual_hypothesis = code;

		for (StartedGamePlayerEventsListener listener: this.listeners)
		{
			listener.onPlayerMadeHypothesis(code);
		}
	}

	public void eliminate()
	{
		this.eliminated = true;

		for (StartedGamePlayerEventsListener listener: this.listeners)
		{
			listener.onPlayerEliminated();
		}
	}

	public void whenEventEmitted(StartedGamePlayerEventsListener listener) {
		this.listeners.add(listener);
	}
}
