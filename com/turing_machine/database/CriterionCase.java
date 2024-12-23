package com.turing_machine.database;

import com.turing_machine.base_objects.Code;

public class CriterionCase implements MatchCheckable {

	private int case_id;

	protected CriterionCase(int id) {

	}

	public int getId() {
		return 0;
	}

	public boolean equals(CriterionCase case2) {
		return false;
	}


	/**
	 * @see com.turing_machine.database.MatchCheckable#doesMatch(com.turing_machine.base_objects.Code)
	 */
	public boolean doesMatch(Code code) {
		return false;
	}

}
