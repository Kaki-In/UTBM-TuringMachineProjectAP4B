package com.turring_machine.views;

import java.util.ArrayList;
import com.turring_machine.listeners.ObjectChangeListener;
import com.turring_machine.configuration.PlayerConfiguration;
import com.turring_machine.listeners.ObjectSelectionListener;

public class ConfiguratingPlayerPanel implements Displayable {

	private ArrayList<ObjectChangeListener<String>> name_listeners;

	private PlayerConfiguration configuration;

	public ConfiguratingPlayerPanel(PlayerConfiguration configuration) {

	}

	public String getName() {
		return null;
	}

	public void setName(String name) {

	}

	public void whenPlayerNameModified(ObjectSelectionListener<String> listener) {

	}

}
