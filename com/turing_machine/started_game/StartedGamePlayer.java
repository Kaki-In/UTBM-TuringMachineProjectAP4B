package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;
import com.turing_machine.listeners.StartedGamePlayerEventsListener;
import java.util.ArrayList;

public class StartedGamePlayer {

	private String name;

	private boolean eliminated;

	private ArrayList<StartedGamePlayerEventsListener> listeners;

	private Code actual_hypothesis;

	public StartedGamePlayer(String name, StartedGamePlayerNotes notes) {

	}

	public String getName() {
		return null;
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

	public StartedGamePlayerNotes getNotes(){
		return null;
	}

	public void guessCode(Code code)
	{

	}

	public void eliminate()
	{
		
	}

	public void whenEventEmitted(StartedGamePlayerEventsListener listener, StartedGamePlayerNotes notes) {

	}
}
