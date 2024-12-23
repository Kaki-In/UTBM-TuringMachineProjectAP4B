package com.turing_machine.views;

import com.turing_machine.listeners.ObjectsListModificationLaunchedListener;
import com.turing_machine.configuration.PlayersConfiguration;
import java.util.ArrayList;

public class PlayersConfigurationPanel implements Displayable {

	private ObjectsListModificationLaunchedListener<String> panel_listeners;

	private PlayersConfiguration configuration;

	private ArrayList<ConfiguratingPlayerPanel> players;

	public PlayersConfigurationPannel(PlayersConfiguration configuration) {

	}

	public void whenPanelModified(ObjectsListModificationLaunchedListener<String> listener) {

	}

}
