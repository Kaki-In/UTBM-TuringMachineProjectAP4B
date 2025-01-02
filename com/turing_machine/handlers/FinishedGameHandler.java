package com.turing_machine.handlers;

import com.turing_machine.configuration.GameConfiguration;
import com.turing_machine.platform_state.ConfiguratingGameStep;
import com.turing_machine.platform_state.MainPlatformState;

public class FinishedGameHandler extends PlatformHandler {

	public FinishedGameHandler(MainPlatformState state) {
		super(state);
	}

	public void restartGame() {
		MainPlatformState state = getState();

		state.setActualStep(new ConfiguratingGameStep(new GameConfiguration()));
	}

}
