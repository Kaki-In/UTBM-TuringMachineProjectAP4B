package com.turring_machine.started_game;

import com.turring_machine.base_objects.Code;
import java.util.ArrayList;
import com.turring_machine.listeners.ObjectsListChangeListener;

public class StartedGamePlayerTestedCodesLine {

	private Code code;

	private StartedGamePlayerTestedCodeValidationResult[] validation_results;

	private ArrayList<ObjectsListChangeListener<StartedGamePlayerTestedCodeValidationResult>> validation_listeners;

	public StartedGamePlayerTestedCodesLine() {

	}

	public ArrayList<StartedGamePlayerTestedCodeValidationResult> getCodeValidationResults() {
		return null;
	}

	public void whenValidationChanged(ObjectsListChangeListener<StartedGamePlayerTestedCodeValidationResult> listener) {

	}

	public int getValidationsCount() {
		return 0;
	}

	public void setCode(Code code) {

	}

	public void addValidationResult(StartedGamePlayerTestedCodeValidationResult result) {

	}

}
