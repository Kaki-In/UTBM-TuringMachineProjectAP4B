package com.turing_machine.configuration;

import com.turing_machine.listeners.ObjectChangeListener;
import java.util.ArrayList;

public class PlayerConfiguration implements Configurable {

	private String name;

	private ArrayList<ObjectChangeListener<String>> name_listeners;

	public PlayerConfiguration(String name) {

	}

	@Override
	public boolean isReady()
	{
		return false;
	}

	public void whenNameChanged(ObjectChangeListener<String> listener) {

	}

}
