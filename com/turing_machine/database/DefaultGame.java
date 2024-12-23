package com.turing_machine.database;

import com.turing_machine.base_objects.Code;
import java.util.ArrayList;
import com.turing_machine.base_objects.GameDifficulty;
import com.turing_machine.base_objects.GameCriteriaCount;
import com.turing_machine.base_objects.CriterionLetter;

public class DefaultGame {

	private Code code;

	private ArrayList<DefaultGameCriterion> criteria;

	private GameDifficulty difficulty;

	protected DefaultGame(Code code, ArrayList<DefaultGameCriterion> criteria) {

	}

	public Code getCode() {
		return null;
	}

	public ArrayList<DefaultGameCriterion> getCriteria() {
		return null;
	}

	public GameCriteriaCount getCriteriaCount() {
		return null;
	}

	public DefaultGameCriterion getCriterion(CriterionLetter letter) {
		return null;
	}

	public GameDifficulty getDifficulty() {
		return null;
	}

}
