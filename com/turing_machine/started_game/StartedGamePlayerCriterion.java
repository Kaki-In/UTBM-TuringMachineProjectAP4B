package com.turing_machine.started_game;

import com.turing_machine.base_objects.CriterionLetter;
import java.util.ArrayList;

public class StartedGamePlayerCriterion {

	private final int criterion_id;

	private final CriterionLetter letter;

	private final ArrayList<StartedGamePlayerCriterionCase> cases;

	public StartedGamePlayerCriterion(int criterion_id, CriterionLetter letter, ArrayList<StartedGamePlayerCriterionCase> cases) {
		this.criterion_id = criterion_id;
		this.letter = letter;
		this.cases = cases;
	}

	public ArrayList<StartedGamePlayerCriterionCase> getCases() {
		return this.cases;
	}

	public int getId() {
		return this.criterion_id;
	}

	public CriterionLetter getLetter() {
		return this.letter;
	}

}
