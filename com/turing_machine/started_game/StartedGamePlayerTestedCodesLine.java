package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.exceptions.GameConstraintException;
import com.turing_machine.listeners.StartedGameCodesLineListener;
import java.util.ArrayList;

public class StartedGamePlayerTestedCodesLine {

	private Code code;

	private final int round_id;

	private final StartedGamePlayerTestedCodeValidationResult[] validation_results;

	private final ArrayList<StartedGameCodesLineListener> validation_listeners;

	private final StartedGameState state;

	private boolean disabled;

	public StartedGamePlayerTestedCodesLine(StartedGameState state, int round) {
		this.code = null;
		this.validation_results = new StartedGamePlayerTestedCodeValidationResult[] {null, null, null};
		this.validation_listeners = new ArrayList<>();

		this.disabled = false;

		this.state = state;
		this.round_id = round;
	}

	public ArrayList<StartedGamePlayerTestedCodeValidationResult> getCodeValidationResults() {
		ArrayList result = new ArrayList<>();

		for (int i=0; i < 3 && validation_results[i] != null; ++i)
		{
			result.add(validation_results[i]);
		}

		return result;
	}

	public int getValidationsCount() {
		return getCodeValidationResults().size();
	}

	public void setCode(Code code) throws GameConstraintException {
		if (this.code != null && this.getValidationsCount() > 0)
		{
			throw new GameConstraintException("can't choose a code twice on the same round");
		}

		this.code = code;

		for (StartedGameCodesLineListener listener: this.validation_listeners)
		{
			listener.onCodeDecided(code);
		}
	}

	public Code getCode()
	{
		return this.code;
	}

	public void addValidationResult(StartedGamePlayerTestedCodeValidationResult result) {
		this.validation_results[getValidationsCount()] = result;

		for (StartedGameCodesLineListener listener: this.validation_listeners)
		{
			listener.onVerificationDone(result);
		}
	}

	public void verify(CriterionLetter letter) throws GameConstraintException
	{
		if (this.state.getRoundId() != this.round_id) {
			throw new GameConstraintException("this round is finished yet");
		}

		if (this.disabled) {
			throw new GameConstraintException("you have been eliminated");
		}

		if (this.getValidationsCount() == 3)
		{
			throw new GameConstraintException("can't verify more than 3 times in a round");
		}

		if (this.getCode() == null)
		{
			throw new GameConstraintException("please choose first a code!");
		}

		StartedGameCriterion true_criterion = this.state.getMachine().getCriteria().getCriterion(letter);

		boolean match = true_criterion.doesMatchSame(this.code, this.state.getMachine().getCode());

		this.addValidationResult(new StartedGamePlayerTestedCodeValidationResult(this.code, letter, match));
	}

	public StartedGameState getState()
	{
		return this.state;
	}

	public int getRoundId()
	{
		return this.round_id;
	}

	public void disable()
	{
		this.disabled = true;
	}

	public boolean isDisabled()
	{
		return this.disabled;
	}

	public void whenNewValidation(StartedGameCodesLineListener listener) {
		this.validation_listeners.add(listener);
	}

}
