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
		return !this.name.replaceAll(" ", "").equals("");
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
		if (name.equals(this.name)) return;

		String last_name = this.name;
		this.name = name;

		for (ObjectChangeListener<String> listener : this.name_listeners)
		{
			listener.onObjectChanged(last_name, name);
		}
	}

}
