package com.turing_machine.configuration;

import java.util.ArrayList;
import com.turing_machine.listeners.ObjectChangeListener;

public class PlayerConfiguration implements Configurable {

	private String name;

	private ArrayList<ObjectChangeListener<String>> name_listeners;

	public PlayerConfiguration(String name) {

	}

	public void whenNameChanged(ObjectChangeListener<String> listener) {

	}

}
