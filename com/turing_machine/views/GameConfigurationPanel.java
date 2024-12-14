package com.turing_machine.views;

import java.util.ArrayList;
import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.platform_state.ConfiguratingGameStep;

public class GameConfigurationPanel extends GameDisplayedPanel {

	private ArrayList<Runnable> listeners;

	private GameConfiguration configuration;

	private CodeConfigurationPanel code;

	private PlayersConfigurationPanel players;

	public GameConfigurationPanel(ConfiguratingGameStep configuration) {

	}

	public void whenGameStartLaunched(Runnable listener) {

	}

}
