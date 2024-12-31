package com.turing_machine.configuration;

import com.turing_machine.base_objects.GameCriteriaCount;
import com.turing_machine.base_objects.GameDifficulty;
import com.turing_machine.listeners.ObjectChangeListener;
import java.util.ArrayList;

public class MachineConfiguration implements Configurable {

	private GameDifficulty difficulty;

	private GameCriteriaCount criteria_count;

	private ArrayList<ObjectChangeListener<GameDifficulty>> difficulty_listeners;

	private ArrayList<ObjectChangeListener<GameCriteriaCount>> criteria_count_listeners;

	public MachineConfiguration() {

	}

	@Override
	public boolean isReady()
	{
		return false;
	}

	public MachineConfiguration(GameDifficulty difficulty) {

	}

	public MachineConfiguration(GameCriteriaCount count) {

	}

	public MachineConfiguration(GameDifficulty difficulty, GameCriteriaCount count) {

	}

	public GameDifficulty getGameDifficulty() {
		return null;
	}

	public GameCriteriaCount getCriteriaCount() {
		return null;
	}

	public void setGameDifficulty(GameDifficulty game_difficulty) {

	}

	public void setCriteriaCount(GameCriteriaCount count) {

	}

	public void whenGameDifficultyChanged(ObjectChangeListener<GameDifficulty> listener) {

	}

	public void whenCriteriaCountChanged(ObjectChangeListener<GameCriteriaCount> listener) {

	}

}
