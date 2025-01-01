package com.turing_machine.database;

import java.util.ArrayList;

public class Criterion {

	private final int id;

	private final ArrayList<CriterionCase> cases;

	protected Criterion(int id, ArrayList<CriterionCase> cases) {
		this.id = id;
		this.cases = cases;
	}

	public int getId() {
		return this.id;
	}

	public ArrayList<CriterionCase> getDistinctCases() {
		return this.cases;
	}

}
