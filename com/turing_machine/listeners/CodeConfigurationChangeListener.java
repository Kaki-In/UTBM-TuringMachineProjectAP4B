package com.turing_machine.listeners;

import com.turing_machine.base_objects.GameCriteriaCount;
import com.turing_machine.base_objects.GameDifficulty;

public interface CodeConfigurationChangeListener {

	public abstract void onGameDifficultyChanged(GameDifficulty new_difficulty);

	public abstract void onGameCriteriaCountChanged(GameCriteriaCount new_count);

	public abstract void onUseApiChanged(boolean now_uses);

}
