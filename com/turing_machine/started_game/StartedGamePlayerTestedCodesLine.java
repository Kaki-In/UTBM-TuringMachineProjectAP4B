package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;
import com.turing_machine.listeners.ObjectSelectionListener;
import java.util.ArrayList;

public class StartedGamePlayerTestedCodesLine {

	private Code code;

	private StartedGamePlayerTestedCodeValidationResult[] validation_results;

	private ArrayList<ObjectSelectionListener<StartedGamePlayerTestedCodeValidationResult>> validation_listeners;

	public StartedGamePlayerTestedCodesLine() {

	}

	public ArrayList<StartedGamePlayerTestedCodeValidationResult> getCodeValidationResults() {
		return null;
	}

	public int getValidationsCount() {
		return 0;
	}

	public void setCode(Code code) {

	}

	public void addValidationResult(StartedGamePlayerTestedCodeValidationResult result) {

	}

	public void whenNewValidation(ObjectSelectionListener<StartedGamePlayerTestedCodeValidationResult> listener) {

	}

}
