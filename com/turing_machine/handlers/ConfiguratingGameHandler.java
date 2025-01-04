package com.turing_machine.handlers;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.exceptions.NotReadyConfigurationException;
import com.turing_machine.platform_state.BuildGameStep;
import com.turing_machine.platform_state.ConfiguratingGameStep;
import com.turing_machine.platform_state.MainPlatformState;

public class ConfiguratingGameHandler extends PlatformHandler {

	public ConfiguratingGameHandler(MainPlatformState state) {
		super(state);

		if (state.getActualStep() instanceof ConfiguratingGameStep confgameStep)
		{
			confgameStep.whenGameStartLaunched(() -> {
				try {
					startGame();
				} catch (NotReadyConfigurationException e) {

				}
			});
		}

		state.whenPlatformStepChanged((last_step, new_step) -> {
			if (new_step instanceof ConfiguratingGameStep confgameStep)
			{
				confgameStep.whenGameStartLaunched(() ->  {
					try {
						startGame();
					} catch (NotReadyConfigurationException e) {
						
					}
				});
			}
		});
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
