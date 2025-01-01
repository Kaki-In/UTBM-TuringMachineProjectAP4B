package com.turing_machine.database;

public class DefaultGameCriterion {

	private final int id;

	private final int good_case;

	protected DefaultGameCriterion(int id, int good_case) {
		this.id = id;
		this.good_case = good_case;
	}

	public int getId() {
		return this.id;
	}

	public int getGoodCase() {
		return this.good_case;
	}

}
