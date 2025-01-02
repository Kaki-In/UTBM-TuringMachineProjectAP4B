package com.turing_machine.database;

import com.turing_machine.base_objects.CriterionLetter;

public class DefaultGameCriterion {

	private final int id;

	private final int good_case;

	private final CriterionLetter letter;

	protected DefaultGameCriterion(int id, CriterionLetter letter, int good_case) {
		this.id = id;
		this.good_case = good_case;
		this.letter = letter;
	}

	public int getId() {
		return this.id;
	}

	public int getGoodCase() {
		return this.good_case;
	}

	public CriterionLetter getLetter() {
		return this.letter;
	}

}
