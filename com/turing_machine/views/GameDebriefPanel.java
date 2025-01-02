package com.turing_machine.views;

import com.turing_machine.listeners.GameDebriefListener;
import com.turing_machine.platform_state.GameDebriefingStep;
import java.awt.Component;
import java.util.ArrayList;

public class GameDebriefPanel extends GameDisplayedPanel {

	private GameDebriefingStep debrief;

	private ArrayList<GameDebriefListener> listeners;

	private GameWinnersPanel winners;

	public GameDebriefPanel(GameDebriefingStep step) {
		super(step);
	}

	public void whenNewGameLaunched(GameDebriefListener listener) {

	}

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Component getWidget() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
