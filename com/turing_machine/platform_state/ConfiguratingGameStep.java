package com.turing_machine.platform_state;

import com.turing_machine.configuration.GameConfiguration;
import java.util.ArrayList;

public class ConfiguratingGameStep extends PlatformStep {

	private final GameConfiguration configuration;

	private final ArrayList<Runnable> listeners;

	public ConfiguratingGameStep(GameConfiguration configuration) {
		this.configuration = configuration;
		this.listeners = new ArrayList<>();
	}

	public void startGame()
	{
		for (Runnable listener: this.listeners)
		{
			listener.run();
		}
	}

	public GameConfiguration getGameConfiguration() {
		return this.configuration;
	}

	public void whenGameStartLaunched(Runnable listener)
	{
		listeners.add(listener);
	}

}
