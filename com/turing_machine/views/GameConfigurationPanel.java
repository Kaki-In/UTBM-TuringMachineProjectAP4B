package com.turing_machine.views;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.platform_state.ConfiguratingGameStep;
import java.awt.Component;
import java.util.ArrayList;

public class GameConfigurationPanel extends GameDisplayedPanel {

	private ArrayList<Runnable> listeners;

	private GameConfiguration configuration;

	private CodeConfigurationPanel code;

	private PlayersConfigurationPanel players;

	public GameConfigurationPanel(ConfiguratingGameStep configuration) {
		super(configuration);
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

	public void whenGameStartLaunched(Runnable listener) {

	}

}
