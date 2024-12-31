package com.turing_machine.configuration;

public class GameConfiguration implements Configurable {

	private MachineConfiguration code;

	private PlayersConfiguration players;

	public GameConfiguration() {

	}

	@Override
	public boolean isReady()
	{
		return false;
	}

	public PlayersConfiguration getPlayersConfiguration() {
		return null;
	}

	public MachineConfiguration getCodeConfiguration() {
		return null;
	}

}
