package com.turing_machine.database;

import com.turing_machine.base_objects.Code;

public class CriterionCase {

	private int case_id;

	private String description;

	private MatchCheckable checker;

	public CriterionCase(int id, MatchCheckable checker) {

	}

	public CriterionId(int id, String description, MatchCheckable checker) {

	}

	public int getId() {
		return 0;
	}

	public String getDescription() {
		return null;
	}

	public boolean equals(CriterionCase case2) {
		return false;
	}

	public void setDescription(String description) {

	}

	public boolean matches(Code code) {
		return false;
	}

}
