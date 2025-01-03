package com.turing_machine.configuration;

public class GameConfiguration implements Configurable {

	private MachineConfiguration code;

	private PlayersConfiguration players;

	public GameConfiguration() {

		this.code = new MachineConfiguration();
		this.players = new PlayersConfiguration();

	}

	@Override
	public boolean isReady()
	{
		return false;
	}

	public PlayersConfiguration getPlayersConfiguration() {
		return players;
	}

	public MachineConfiguration getCodeConfiguration() {
		return code;
	}

}
