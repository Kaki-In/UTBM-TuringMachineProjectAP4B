package com.turing_machine.api;

import com.turing_machine.base_objects.CriterionLetter;

public class TuringMachineGeneratedCriterion {

	private final int id;

	private final CriterionLetter letter;

	private final int good_case;

	public TuringMachineGeneratedCriterion(int id, CriterionLetter letter, int good_case) {
		this.id = id;
		this.letter = letter;
		this.good_case = good_case;
	}

	public int getId() {
		return this.id;
	}

	public CriterionLetter getLetter() {
		return this.letter;
	}

	public int getGoodCase() {
		return this.good_case;
	}

}
