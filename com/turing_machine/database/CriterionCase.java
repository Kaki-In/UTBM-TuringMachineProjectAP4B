package com.turing_machine.database;

import com.turing_machine.base_objects.Code;

public class CriterionCase {

	private final int case_id;
	private final MatchCheckable checker;

	protected CriterionCase(int id, MatchCheckable checker) {
		this.case_id = id;
		this.checker = checker;
	}

	public int getId() {
		return this.case_id;
	}

	public boolean equals(CriterionCase case2) {
		return this.case_id == case2.case_id;
	}


	public boolean doesMatch(Code code) {
		return this.checker.doesMatch(code);
	}

}
