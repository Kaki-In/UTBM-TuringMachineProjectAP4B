package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;

public class StartedGameMachine {

	private final Code unknown_code;

	private final StartedGameCriteriaList criteria;

	public StartedGameMachine(Code code, StartedGameCriteriaList criteria) {
		this.unknown_code = code;
		this.criteria = criteria;
	}

	public StartedGameCriteriaList getCriteria() {
		return this.criteria;
	}

	public Code getCode() {
		return this.unknown_code;
	}

}
