package com.turing_machine.handlers;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.exceptions.NotReadyConfigurationException;
import com.turing_machine.platform_state.BuildGameStep;
import com.turing_machine.platform_state.ConfiguratingGameStep;
import com.turing_machine.platform_state.MainPlatformState;

public class ConfiguratingGameHandler extends PlatformHandler {

	public ConfiguratingGameHandler(MainPlatformState state) {
		super(state);
	}

	public void startGame() throws NotReadyConfigurationException {
		MainPlatformState state = getState();

		ConfiguratingGameStep configurating_step = (ConfiguratingGameStep) state.getActualStep();

		GameConfiguration configuration = configurating_step.getGameConfiguration();

		if (!configuration.isReady())
		{
			throw new NotReadyConfigurationException();
		}

		state.setActualStep(new BuildGameStep(configuration));
	}

}
