package com.turing_machine.views;

import java.awt.Component;
import java.util.ArrayList;

public class StartedGameEnterPlayerPanel extends Displayable {

	private ArrayList<Runnable> listeners;

	private String player_name;

	public StartedGameEnterPlayerPanel(String player_name) {

	}

	public void whenPlayerAskedToEnter(Runnable runnable) {

	}

	@Override
	public Component getWidget()
	{
		return null;
	}

	@Override
	public void refresh()
	{
	}

}
