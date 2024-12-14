package com.turing_machine.views;

import java.util.ArrayList;
import com.turing_machine.listeners.ObjectSelectionListener;
import com.turing_machine.base_objects.GameCriteriaCount;

public class CriteriaCountSelectionPanel implements Displayable {

	private ArrayList<ObjectSelectionListener<GameCriteriaCount>> listeners;

	private GameCriteriaCount count;

	public CriteriaCountSelectionPanel() {

	}

	public GameCriteriaCount getCriteriaCount() {
		return null;
	}

	public void setCriteriaCount(GameCriteriaCount count) {

	}

	public void whenCriteriaCountSelected(ObjectSelectionListener<GameCriteriaCount> listener) {

	}

}
