package com.turring_machine.views;

import com.turring_machine.listeners.ObjectsListModificationLaunchedListener;
import com.turring_machine.configuration.PlayersConfiguration;

public class PlayersConfigurationPanel implements Displayable {

	private ObjectsListModificationLaunchedListener<int> panel_listeners;

	private PlayersConfiguration configuration;

	private ArrayList<ConfiguratingPlayerPanel> players;

	public PlayersConfigurationPannel(PlayersConfiguration configuration) {

	}

	public void whenPanelModified(ObjectsListModificationLaunchedListener<int> listener) {

	}

}
