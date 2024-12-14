package com.turing_machine.listeners;

public interface StartedGamePlayerEventsListener {

	public abstract void onPlayerEliminated();

	public abstract void onPlayerDisabled();

	public abstract void onPlayerEnabled();

	public abstract void onPlayerMadeHypothesis();

}
