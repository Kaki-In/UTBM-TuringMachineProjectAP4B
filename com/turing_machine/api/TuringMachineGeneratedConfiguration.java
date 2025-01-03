package com.turing_machine.api;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.base_objects.GameCriteriaCount;
import com.turing_machine.base_objects.GameDifficulty;
import java.util.ArrayList;

public class TuringMachineGeneratedConfiguration {

	private final Code code;

	private final GameDifficulty difficulty;

	private final GameCriteriaCount criteria_count;

	private final ArrayList<TuringMachineGeneratedCriterion> criteria;

	public TuringMachineGeneratedConfiguration(Code code, GameDifficulty difficulty, GameCriteriaCount criteria_count, ArrayList<TuringMachineGeneratedCriterion> criteria) {
		this.code = code;
		this.difficulty = difficulty;
		this.criteria_count = criteria_count;
		this.criteria = criteria;
	}

	public Code getCode()
	{
		return this.code;
	}

	public GameDifficulty getDifficulty() {
		return this.difficulty;
	}

	public GameCriteriaCount getCriteriaCount() {
		return this.criteria_count;
	}

	public ArrayList<TuringMachineGeneratedCriterion> getCriteria() {
		return this.criteria;
	}

	public TuringMachineGeneratedCriterion getCriterion(CriterionLetter letter) {
		return this.criteria.get(letter.toInteger() - 1);
	}

}
