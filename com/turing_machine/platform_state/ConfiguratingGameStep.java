package com.turing_machine.platform_state;

import com.turing_machine.configuration.GameConfiguration;

public class ConfiguratingGameStep extends PlatformStep {

	private final GameConfiguration configuration;

	public ConfiguratingGameStep(GameConfiguration configuration) {
		this.configuration = configuration;
	}

	public GameConfiguration getGameConfiguration() {
		return this.configuration;
	}

}
