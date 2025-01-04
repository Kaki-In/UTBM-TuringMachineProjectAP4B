package com.turing_machine.started_game;

import com.turing_machine.listeners.CriterionCaseChangeListener;
import java.util.ArrayList;

public class StartedGamePlayerCriterionCase {

	private final int case_id;

	private final ArrayList<CriterionCaseChangeListener> validation_listeners;

	private boolean validated;

	public StartedGamePlayerCriterionCase(int case_id) {
		this.case_id = case_id;

		this.validation_listeners = new ArrayList<>();

		this.validated = true;
	}

	public int getCaseId() {
		return this.case_id;
	}

	public boolean is_validated()
	{
		return this.validated;
	}

	public void validate() {
		this.validated = true;

		for (CriterionCaseChangeListener listener: validation_listeners)
		{
			listener.onCriterionCaseValidation();
		}
	}

	public void unvalidate() {
		this.validated = false;

		for (CriterionCaseChangeListener listener: validation_listeners)
		{
			listener.onCriterionCaseUnvalidation();
		}
	}

	public void whenValidationChanged(CriterionCaseChangeListener listener) {
		this.validation_listeners.add(listener);
	}

}
