package com.turing_machine.views;

import com.turing_machine.configuration.PlayerConfiguration;
import com.turing_machine.listeners.ObjectChangeListener;
import com.turing_machine.listeners.ObjectSelectionListener;
import java.awt.Component;
import java.util.ArrayList;

public class ConfiguratingPlayerPanel implements Displayable {

	private ArrayList<ObjectChangeListener<String>> name_listeners;

	private PlayerConfiguration configuration;

	public ConfiguratingPlayerPanel(PlayerConfiguration configuration) {

	}

	@Override
	public Component getWidget()
	{
		return null;
	}

	@Override
	public void refresh()
	{
	}

	public String getName() {
		return null;
	}

	public void setName(String name) {

	}

	public void whenPlayerNameModified(ObjectSelectionListener<String> listener) {

	}

}
