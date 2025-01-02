package com.turing_machine.views;

import com.turing_machine.started_game.StartedGameMachine;
import java.awt.Component;

public class MachineDiscoveringPanel implements Displayable {

	private StartedGameMachine machine;

	public MachineDiscoveringPanel(StartedGameMachine machine) {

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
