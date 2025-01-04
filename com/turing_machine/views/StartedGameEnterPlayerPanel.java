package com.turing_machine.views;

import javax.swing.JComponent;
import java.util.ArrayList;

public class StartedGameEnterPlayerPanel extends Displayable {

	private ArrayList<Runnable> listeners;

	private String player_name;

	public StartedGameEnterPlayerPanel(String player_name) {

	}

	public void whenPlayerAskedToEnter(Runnable runnable) {

	}

	@Override
	public JComponent getWidget()
	{
		return null;
	}

	@Override
	public void refresh()
	{
	}

}
