package com.turing_machine.views;

import java.util.ArrayList;
import com.turing_machine.listeners.ObjectSelectionListener;
import com.turing_machine.base_objects.GameDifficulty;

public class GameDifficultySelectionPanel implements Displayable {

	private ArrayList<ObjectSelectionListener<GameDifficulty>> listeners;

	private GameDifficulty difficulty;

	public GameDifficultySelectionPanel() {

	}

	public GameDifficulty getGameDifficulty() {
		return null;
	}

	public setGameDifficulty(GameDifficulty difficulty) {

	}

	public void whenGameDifficultySelected(ObjectSelectionListener<GameDifficulty> listener) {

	}

}
