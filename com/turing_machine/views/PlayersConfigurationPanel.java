package com.turing_machine.views;

import com.turing_machine.configuration.PlayersConfiguration;
import com.turing_machine.listeners.ObjectsListModificationLaunchedListener;
import java.awt.Component;
import java.util.ArrayList;

public class PlayersConfigurationPanel implements Displayable {

	private ObjectsListModificationLaunchedListener<String> panel_listeners;

	private PlayersConfiguration configuration;

	private ArrayList<ConfiguratingPlayerPanel> players;

	public PlayersConfigurationPanel(PlayersConfiguration configuration) {

	}

	public void whenPanelModified(ObjectsListModificationLaunchedListener<String> listener) {

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

}
