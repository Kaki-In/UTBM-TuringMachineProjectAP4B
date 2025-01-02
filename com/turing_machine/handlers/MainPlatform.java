package com.turing_machine.handlers;

import com.turing_machine.platform_state.MainPlatformState;

public class MainPlatform {

	private final ConfiguratingGameHandler configurator;

	private final GameBuildHandler builder;

	private final StartedGameHandler game_handler;

	private final MainPlatformState state;

	public MainPlatform() {
		this.state = new MainPlatformState();

		this.configurator = new ConfiguratingGameHandler(this.state);
		this.builder = new GameBuildHandler(this.state);
		this.game_handler = new StartedGameHandler(this.state);
	}

	public MainPlatformState getState() {
		return this.state;
	}

	public ConfiguratingGameHandler getConfiguratingGameHandler()
	{
		return this.configurator;
	}

	public GameBuildHandler getGameBuildHandler()
	{
		return this.builder;
	}

	public StartedGameHandler getStartedGameHandler()
	{
		return this.game_handler;
	}

}
