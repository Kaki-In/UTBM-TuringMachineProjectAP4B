package com.turing_machine.started_game;

import java.util.ArrayList;
import com.turing_machine.base_objects.GameCriteriaCount;
import com.turing_machine.base_objects.CriterionLetter;

public class StartedGameCriteriaList {

	private ArrayList<StartedGameCriterion> criteria;

	public StartedGameCriteriaList(ArrayList<StartedGameCriterion> criteria) {

		if (criteria != null) {
            this.criteria = criteria;
        } else {
            this.criteria = new ArrayList<>();
        }
	}

	public ArrayList<StartedGameCriterion> getCriteria() {
		return criteria;
	}

	public GameCriteriaCount getCriteriaCount() {
		return GameCriteriaCount(criteria.size());
	}

	public StartedGameCriterion getCriterion(CriterionLetter letter) {
	
        for (StartedGameCriterion criterion : criteria) {
            if (criterion.getLetter().equals(letter)) {
                return criterion; 
            }
        }

        return null; // Aucun critère correspondant trouvé
    }

	}


