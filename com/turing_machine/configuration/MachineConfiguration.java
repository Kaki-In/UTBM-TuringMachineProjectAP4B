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

	private ArrayList<ObjectChangeListener<Boolean>> api_listeners;

	private boolean uses_api;

	public MachineConfiguration() {
		this(GameDifficulty.STANDARD, GameCriteriaCount.FOUR_CRITERIA);
	}

	@Override
	public boolean isReady()
	{
		return true;
	}

	public MachineConfiguration(GameDifficulty difficulty) {
		this(difficulty, GameCriteriaCount.FOUR_CRITERIA);
	}

	public MachineConfiguration(GameCriteriaCount count) {
		this(GameDifficulty.STANDARD, GameCriteriaCount.FOUR_CRITERIA);
	}

	public MachineConfiguration(GameDifficulty difficulty, GameCriteriaCount count) {
		this.difficulty = (difficulty != null) ? difficulty : GameDifficulty.STANDARD; // Valeur par défaut : STANDARD
		this.criteria_count = (count != null) ? count : GameCriteriaCount.FOUR_CRITERIA; // Valeur par défaut : FOUR_CRITERIA			this.difficulty_listeners = new ArrayList<>(); 

		this.criteria_count_listeners = new ArrayList<>();
		this.api_listeners = new ArrayList<>(); 
		this.uses_api = false; 
	}

	

	public GameDifficulty getGameDifficulty() {
		return this.difficulty;
	}

	public GameCriteriaCount getCriteriaCount() {
		return this.criteria_count;
	}

	public boolean getUsesApi()
	{
		return this.uses_api;
	}

	public void setGameDifficulty(GameDifficulty game_difficulty) {

		GameDifficulty last_difficulty = game_difficulty;
		this.difficulty = game_difficulty;

		for (ObjectChangeListener<GameDifficulty> listener : this.difficulty_listeners)
		{
			listener.onObjectChanged(last_difficulty, game_difficulty);
		}

	}

	public void setCriteriaCount(GameCriteriaCount count) {

		GameCriteriaCount last_count = count;
		this.criteria_count = count;

		for (ObjectChangeListener<GameCriteriaCount> listener : this.criteria_count_listeners)
		{
			listener.onObjectChanged(last_count, count);
		}

	}

	public void setUsesApi(boolean enabled)
	{
		boolean last_enabled = enabled;
		this.uses_api = enabled;


		for (ObjectChangeListener<Boolean> listener : this.api_listeners)
		{
			listener.onObjectChanged(last_enabled, enabled);
		}

	}

	public void whenGameDifficultyChanged(ObjectChangeListener<GameDifficulty> listener) {

		this.difficulty_listeners.add(listener);
	}

	public void whenCriteriaCountChanged(ObjectChangeListener<GameCriteriaCount> listener) {

		this.criteria_count_listeners.add(listener);
	}

	public void whenUsesApiChanged(ObjectChangeListener<Boolean> listener) {

		this.api_listeners.add(listener);
	}

}
