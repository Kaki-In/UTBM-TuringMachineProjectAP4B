package com.turing_machine.views;

import com.turing_machine.started_game.StartedGamePlayer;
import java.awt.Component;
import java.util.ArrayList;

public class StartedGamePlayerNotesPanel extends Displayable {

	private ArrayList<Runnable> listeners;

	private StartedGamePlayer player;

	private StartedGamePlayerNumbersGridPanel numbers;

	private StartedGamePlayerCriteriaPanel criteria;

	private StartedGamePlayerTestedCodesPanel codes;

	public StartedGamePlayerNotesPanel(StartedGamePlayer player) {

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

	public void whenCloseAction(Runnable listener) {

	}

}
