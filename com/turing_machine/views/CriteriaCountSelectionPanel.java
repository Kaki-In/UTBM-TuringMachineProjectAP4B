package com.turing_machine.views;

import com.turing_machine.base_objects.GameCriteriaCount;
import com.turing_machine.listeners.ObjectSelectionListener;
import java.awt.Component;
import java.util.ArrayList;

public class CriteriaCountSelectionPanel implements Displayable {

	private ArrayList<ObjectSelectionListener<GameCriteriaCount>> listeners;

	private GameCriteriaCount count;

	public CriteriaCountSelectionPanel() {

	}

	@Override
	public Component getWidget()
	{
		return null;
	}

	@Override
	public void refresh()
	{
	}

	public GameCriteriaCount getCriteriaCount() {
		return null;
	}

	public void setCriteriaCount(GameCriteriaCount count) {

	}

	public void whenCriteriaCountSelected(ObjectSelectionListener<GameCriteriaCount> listener) {

	}

}
