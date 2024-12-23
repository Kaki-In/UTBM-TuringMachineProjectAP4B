package com.turing_machine.listeners;

import com.turing_machine.base_objects.GameDifficulty;
import com.turing_machine.base_objects.GameCriteriaCount;

public interface CodeConfigurationChangeListener {

	public abstract void onGameDifficultyChanged(GameDifficulty last_difficulty, GameDifficulty new_difficulty);

	public abstract void onGameCriteriaCountChanged(GameCriteriaCount last_count, GameCriteriaCount new_count);

}
