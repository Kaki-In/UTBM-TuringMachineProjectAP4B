package com.turing_machine.started_game;

import com.turing_machine.base_objects.CodeComponent;
import com.turing_machine.listeners.PlayerNumbersGridChangeListener;
import java.util.ArrayList;

public class StartedGamePlayerNumbersGrid {

	private final ArrayList<PlayerNumbersGridChangeListener> validation_listeners;

	private final boolean[] validations;

	public StartedGamePlayerNumbersGrid() {
		this.validation_listeners = new ArrayList<>();
		this.validations = new boolean[25];

		for (int i=0; i < 25; ++i) this.validations[i] = true;
	}

	private int getComponentIndex(CodeComponent component)
	{
		return (component.getIndex().toInteger()-1)*5 + component.getValue().toInteger() - 1;
	}

	public boolean numberIsUnvalidated(CodeComponent position) {
		return this.validations[getComponentIndex(position)];
	}

	public void validateNumber(CodeComponent position) {
		this.validations[getComponentIndex(position)] = true;

		for (PlayerNumbersGridChangeListener listener: this.validation_listeners)
		{
			listener.onNumberValidated(position);
		}
	}

	public void unvalidateNumber(CodeComponent position) {
		this.validations[getComponentIndex(position)] = false;

		for (PlayerNumbersGridChangeListener listener: this.validation_listeners)
		{
			listener.onNumberUnvalidated(position);
		}
	}

	public void whenNumberStatusChanged(PlayerNumbersGridChangeListener listener) {

		validation_listeners.add(listener);

	}

}
