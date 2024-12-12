package com.turring_machine.views;

import java.util.ArrayList;
import com.turring_machine.configuration.GameConfiguration;
import com.turring_machine.platform_state.ConfiguratingGameStep;

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
