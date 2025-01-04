package com.turing_machine.started_game;

import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.base_objects.GameCriteriaCount;
import java.util.ArrayList;

public class StartedGamePlayerCriteria {

	private final ArrayList<StartedGamePlayerCriterion> criteria;

	public StartedGamePlayerCriteria(ArrayList<StartedGamePlayerCriterion> criteria) {
		this.criteria = criteria;
	}

	public StartedGamePlayerCriterion getCriterion(CriterionLetter letter) {
		return this.criteria.get(letter.toInteger());
	}

	public GameCriteriaCount getCriteriaCount() {
		return GameCriteriaCount.fromInteger(criteria.size());
	}

}
