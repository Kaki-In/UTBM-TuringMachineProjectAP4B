package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;
import com.turing_machine.exceptions.GameConstraintException;
import com.turing_machine.listeners.StartedGameCodesLineListener;
import java.util.ArrayList;

public class StartedGamePlayerTestedCodesLine {

	private Code code;

	private final StartedGamePlayerTestedCodeValidationResult[] validation_results;

	private final ArrayList<StartedGameCodesLineListener> validation_listeners;

	private final StartedGameState state;

	public StartedGamePlayerTestedCodesLine(StartedGameState state) {
		this.code = null;
		this.validation_results = new StartedGamePlayerTestedCodeValidationResult[] {null, null, null};
		this.validation_listeners = new ArrayList<>();

		this.state = state;
	}

	public ArrayList<StartedGamePlayerTestedCodeValidationResult> getCodeValidationResults() {
		ArrayList result = new ArrayList<>();

		for (int i=0; validation_results[i] != null && i < 3; ++i)
		{
			result.add(validation_results[i]);
		}

		return result;
	}

	public int getValidationsCount() {
		return getCodeValidationResults().size();
	}

	public void setCode(Code code) throws GameConstraintException {
		if (this.code != null)
		{
			throw new GameConstraintException("can't choose a code twice on the same round");
		}

		this.code = code;

		for (StartedGameCodesLineListener listener: this.validation_listeners)
		{
			listener.onCodeDecided(code);
		}
	}

	public void addValidationResult(StartedGamePlayerTestedCodeValidationResult result) {
		this.validation_results[this.getValidationsCount()] = result;

		for (StartedGameCodesLineListener listener: this.validation_listeners)
		{
			listener.onVerificationDone(result);
		}
	}

	public void verify(StartedGameCriterion criterion) throws GameConstraintException
	{
		if (this.getValidationsCount() == 3)
		{
			throw new GameConstraintException("can't verify more than 3 times in a round");
		}

		StartedGameCriterion true_criterion = this.state.getMachine().getCriteria().getCriterion(criterion.getLetter());

		boolean match = true_criterion.doesMatchSame(this.code, this.state.getMachine().getCode());

		this.addValidationResult(new StartedGamePlayerTestedCodeValidationResult(this.code, criterion.getLetter(), match));
	}

	public void whenNewValidation(StartedGameCodesLineListener listener) {
		this.validation_listeners.add(listener);
	}

}
