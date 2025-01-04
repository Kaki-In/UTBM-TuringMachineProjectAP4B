package com.turing_machine.listeners;

import com.turing_machine.base_objects.Code;

public interface StartedGamePlayerEventsListener {

	public abstract void onPlayerEliminated();

	public abstract void onPlayerDisabled();

	public abstract void onPlayerEnabled();

	public abstract void onPlayerMadeHypothesis(Code code);

}
