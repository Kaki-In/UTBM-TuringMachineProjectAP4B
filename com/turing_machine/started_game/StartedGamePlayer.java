package com.turing_machine.started_game;

import java.util.ArrayList;
import com.turing_machine.listeners.StartedGamePlayerEventsListener;
import com.turing_machine.base_objects.Code;

public class StartedGamePlayer {

	private String name;

	private boolean /disabled;

	private boolean eliminated;

	private ArrayList<StartedGamePlayerEventsListener> listeners;

	private Code actual_hypothesis;

	public StartedGamePlayer(String name) {

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

	public Code getGuessingCode() {
		return null;
	}

}
