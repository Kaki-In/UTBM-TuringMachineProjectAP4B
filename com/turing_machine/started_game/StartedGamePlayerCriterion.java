package com.turing_machine.started_game;

import java.util.ArrayList;

public class StartedGamePlayerCriterion {

	private final int criterion_id;

	private final ArrayList<StartedGamePlayerCriterionCase> cases;

	public StartedGamePlayerCriterion(int criterion_id, ArrayList<StartedGamePlayerCriterionCase> cases) {
		this.criterion_id = criterion_id;
		this.cases = cases;
	}

	public ArrayList<StartedGamePlayerCriterionCase> getCases() {
		return this.cases;
	}

	public int getId() {
		return this.criterion_id;
	}

}
