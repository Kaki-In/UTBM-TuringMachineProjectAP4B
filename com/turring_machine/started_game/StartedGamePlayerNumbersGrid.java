package com.turring_machine.started_game;

import java.util.ArrayList;
import com.turring_machine.listeners.PlayerNumbersGridChangeListener;
import com.turring_machine.base_objects.CodeComponent;

public class StartedGamePlayerNumbersGrid {

	private ArrayList<PlayerNumbersGridChangeListener> validation_listeners;

	private boolean[] validations;

	public StartedGamePlayerNumbersGrid() {

	}

	public boolean numberIsUnvalidated(CodeComponent position) {
		return false;
	}

	public void validateNumber(CodeComponent position) {

	}

	public void unvalidateNumber(CodeComponent position) {

	}

	public void whenNumberStatusChanged(PlayerNumbersGridChangeListener listener) {

	}

}
