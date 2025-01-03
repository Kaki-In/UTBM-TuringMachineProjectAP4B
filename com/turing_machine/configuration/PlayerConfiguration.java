package com.turing_machine.configuration;

import com.turing_machine.listeners.ObjectChangeListener;
import java.util.ArrayList;

public class PlayerConfiguration implements Configurable {

	private String name;

	private final ArrayList<ObjectChangeListener<String>> name_listeners;

	public PlayerConfiguration(String name) {
		this.name_listeners = new ArrayList<>();
		this.name = name;
	}

	@Override
	public boolean isReady()
	{
		return false;
	}

	public void whenNameChanged(ObjectChangeListener<String> listener) {
		this.name_listeners.add(listener);
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;

	}

}
