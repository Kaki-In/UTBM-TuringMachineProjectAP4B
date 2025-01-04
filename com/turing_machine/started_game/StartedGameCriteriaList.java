package com.turing_machine.started_game;

import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.base_objects.GameCriteriaCount;
import java.util.ArrayList;

public class StartedGameCriteriaList {

	private final ArrayList<StartedGameCriterion> criteria;

	public StartedGameCriteriaList(ArrayList<StartedGameCriterion> criteria) {
		this.criteria = criteria;
	}

	public ArrayList<StartedGameCriterion> getCriteria() {
		return criteria;
	}

	public GameCriteriaCount getCriteriaCount() {
		return GameCriteriaCount.fromInteger(criteria.size());
	}

	public StartedGameCriterion getCriterion(CriterionLetter letter) {
		return this.criteria.get(letter.toInteger());
    }

}


