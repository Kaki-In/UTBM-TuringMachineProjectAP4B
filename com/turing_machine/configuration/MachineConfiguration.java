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

		this.difficulty = game_difficulty.EASY; 
		this.criteria_count = new GameCriteriaCount(); 
		this.difficulty_listeners = new ArrayList<>(); 
		this.criteria_count_listeners = new ArrayList<>(); 
		this.api_listeners = new ArrayList<>(); 
		this.uses_api = false;

	}

	@Override
	public boolean isReady()
	{
		return false;
	}

	public MachineConfiguration(GameDifficulty difficulty) {

		if (difficulty != null) {
			this.difficulty = difficulty;
		} else {
			this.difficulty = GameDifficulty.STANDARD;
		}

		
		this.difficulty_listeners = new ArrayList<>(); 
		this.criteria_count_listeners = new ArrayList<>();
		this.api_listeners = new ArrayList<>(); 
		this.uses_api = false; 


	}

	public MachineConfiguration(GameCriteriaCount count) {

		if (count != null) {
			this.count = count;
		} else {
			this.count= GameCriteriaCount.FOUR_CRITERIA;
		}

		this.difficulty_listeners = new ArrayList<>(); 
		this.criteria_count_listeners = new ArrayList<>();
		this.api_listeners = new ArrayList<>(); 
		this.uses_api = false; 

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

		this.difficulty = game_difficulty;

	}

	public void setCriteriaCount(GameCriteriaCount count) {

		this.criteria_count = count;

	}

	public void setUsesApi(boolean enabled)
	{
		this.uses_api=enabled;
	}

	public void whenGameDifficultyChanged(ObjectChangeListener<GameDifficulty> listener) {

		this.difficulty_listeners.add(listener);

		for (ObjectsListChangeListener<MachineConfiguration> listener : this.difficulty_listeners)
		{
			listener.onObjectChanged(listener, this.listeners);
		}
	}

	public void whenCriteriaCountChanged(ObjectChangeListener<GameCriteriaCount> listener) {

		this.criteria_count_listeners.add(listener);

		for (ObjectsListChangeListener<MachineConfiguration> listener : this.criteria_count_listeners)
		{
			listener.onObjectChanged(listener, this.listeners);
		}
	}

	public void whenUsesApiChanged(ObjectChangeListener<Boolean> listener) {

		this.api_listeners.add(listener);

		for (ObjectsListChangeListener<MachineConfiguration> listener : this.api_listeners)
		{
			listener.onObjectChanged(listener, this.listeners);
		}
	}

}
