package com.turring_machine.configuration;

import com.turring_machine.base_objects.GameDifficulty;
import com.turring_machine.base_objects.GameCriteriaCount;
import java.util.ArrayList;
import com.turring_machine.listeners.ObjectChangeListener;

public class MachineConfiguration implements Configurable {

	private GameDifficulty difficulty;

	private GameCriteriaCount criteria_count;

	private ArrayList<ObjectChangeListener<GameDifficulty>> difficulty_listener;

	private ArrayList<ObjectChangeListener<GameCriteriaCount>> criteria_count_listener;

	public MachineConfiguration() {

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
