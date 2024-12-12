package com.turring_machine.started_game;

import java.util.ArrayList;
import com.turring_machine.listeners.StartedGamePlayerEventsListener;

public class StartedGamePlayer {

	private String name;

	private boolean /disabled;

	private boolean eliminated;

	private ArrayList<StartedGamePlayerEventsListener> listeners;

	private StartedGamePlayerCodeHypothesis actual_hypothesis;

	public startedGamePlayer(String name) {

	}

	public boolean isHypothesing() {
		return false;
	}

	public StartedGamePlayerCodeHypothesis getHypothesis() {
		return null;
	}

	public void whenEventEmitted(StartedGamePlayerEventsListener listener) {

	}

	public boolean isDisabled() {
		return false;
	}

	public boolean isEliminated() {
		return false;
	}

	public boolean isGuessingACode() {
		return false;
	}

	public StartedGamePlayerCodeHypothesis getGuessingCode() {
		return null;
	}

}
