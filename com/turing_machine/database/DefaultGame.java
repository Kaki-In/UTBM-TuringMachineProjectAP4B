package com.turing_machine.database;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.base_objects.GameCriteriaCount;
import com.turing_machine.base_objects.GameDifficulty;
import java.util.ArrayList;

public class DefaultGame {

	private final Code code;
	private final ArrayList<DefaultGameCriterion> criteria;
	private final GameDifficulty difficulty;

	protected DefaultGame(Code code, ArrayList<DefaultGameCriterion> criteria, GameDifficulty difficulty) {
		this.code = code;
		this.criteria = criteria;
		this.difficulty = difficulty;
	}

	public Code getCode() {
		return this.code;
	}

	public ArrayList<DefaultGameCriterion> getCriteria() {
		return this.criteria;
	}

	public GameCriteriaCount getCriteriaCount() {
		return GameCriteriaCount.fromInteger(this.criteria.size());
	}

	public DefaultGameCriterion getCriterion(CriterionLetter letter) {
		return this.criteria.get(letter.toInteger() - 1);
	}

	public GameDifficulty getDifficulty() {
		return this.difficulty;
	}

}
