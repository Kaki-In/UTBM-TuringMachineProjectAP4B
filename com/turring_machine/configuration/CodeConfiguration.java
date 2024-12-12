package com.turring_machine.configuration;

import com.turring_machine.base_objects.GameDifficulty;
import com.turring_machine.base_objects.GameCriteriaCount;
import com.turring_machine.listeners.ObjectChangeListener;

public class CodeConfiguration implements Configurable {

	private GameDifficulty difficulty;

	private GameCriteriaCount criteria_count;

	private ArrayList<ObjectChangeListener<GameDifficulty>> difficulty_listener;

	private ArrayList<ObjectChangeListener<GameCriteriaCount>> criteria_count_listener;

	public CodeConfiguration() {

	}

	public CodeConfiguration(GameDifficulty difficulty) {

	}

	public CodeConfiguration(GameCriteriaCount count) {

	}

	public CodeConfiguration(GameDifficulty difficulty, GameCriteriaCount count) {

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
