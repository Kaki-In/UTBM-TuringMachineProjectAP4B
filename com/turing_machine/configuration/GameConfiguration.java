package com.turing_machine.configuration;

public class GameConfiguration implements Configurable {

	private final MachineConfiguration code;

	private final PlayersConfiguration players;

	public GameConfiguration() {

		this.code = new MachineConfiguration();
		this.players = new PlayersConfiguration();

	}

	@Override
	public boolean isReady()
	{
		return this.code.isReady() && this.players.isReady();
	}

	public PlayersConfiguration getPlayersConfiguration() {
		return players;
	}

	public MachineConfiguration getCodeConfiguration() {
		return code;
	}

}
