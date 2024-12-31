package com.turing_machine.views;

import com.turing_machine.base_objects.GameDifficulty;
import com.turing_machine.listeners.ObjectSelectionListener;
import java.awt.Component;
import java.util.ArrayList;

public class GameDifficultySelectionPanel implements Displayable {

	private ArrayList<ObjectSelectionListener<GameDifficulty>> listeners;

	private GameDifficulty difficulty;

	public GameDifficultySelectionPanel() {

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

	public GameDifficulty getGameDifficulty() {
		return null;
	}

	public void setGameDifficulty(GameDifficulty difficulty) {

	}

	public void whenGameDifficultySelected(ObjectSelectionListener<GameDifficulty> listener) {

	}

}
