package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CriterionLetter;

public class StartedGamePlayerTestedCodeValidationResult {

	private final Code code;

	private final CriterionLetter letter;

	private final boolean match;

	public StartedGamePlayerTestedCodeValidationResult(Code code, CriterionLetter letter, boolean matched) {
		this.code = code;
		this.letter = letter;
		this.match = matched;
	}

	public Code getEffectiveCode() {
		return this.code;
	}

	public CriterionLetter getCriterionLetter() {
		return this.letter;
	}

	public boolean hasMatched() {
		return this.match;
	}

}
