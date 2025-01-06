package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.database.CriteriaDatabase;
import com.turing_machine.database.CriterionCase;
import com.turing_machine.database.Database;
import com.turing_machine.exceptions.NoSuchCaseException;

public class StartedGameCriterion {

	private final int criterion_id;

	private final CriterionLetter letter;

	private final int good_case;

	public StartedGameCriterion(int criterion_id, CriterionLetter letter, int good_case) {
		this.criterion_id = criterion_id;
		this.letter = letter;
		this.good_case = good_case;
	}

	public int getCriterionId() {
		return this.criterion_id;
	}

	public CriterionLetter getLetter() {
		return this.letter;
	}

	public CriterionCase getGoodCase() {
		try {
			return Database.getCriteria().getCriteriaCases().getCriterionCase(this.good_case);
		} catch (NoSuchCaseException exc) {
			System.err.println("Warning : the good case has not been found");
			return null;
		}
	}

	public boolean doesMatchSame(Code code, Code good_code)
	{
		return this.getGoodCase().doesMatch(code);
	}
}
