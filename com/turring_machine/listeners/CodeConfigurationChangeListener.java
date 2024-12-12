package com.turring_machine.listeners;

import com.turring_machine.base_objects.GameDifficulty;
import com.turring_machine.base_objects.GameCriteriaCount;

public interface CodeConfigurationChangeListener {

	public abstract void onGameDifficultyChanged(GameDifficulty lalst_difficulty, GameDifficulty new_difficulty);

	public abstract void onGameCriteriaCountChanged(GameCriteriaCount last_count, GameCriteriaCount new_count);

}
