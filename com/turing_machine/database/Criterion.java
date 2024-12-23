package com.turing_machine.database;

import java.util.ArrayList;
import com.turing_machine.base_objects.Code;

public class Criterion {

	private int id;

	private ArrayList<CriterionCase> cases;

	protected Criterion(int id, ArrayList<CriterionCase> cases) {

	}

	public int getId() {
		return 0;
	}

	public ArrayList<CriterionCase> getDistinctCases() {
		return null;
	}

	public void getMatchingCase(Code code) {

	}

}
