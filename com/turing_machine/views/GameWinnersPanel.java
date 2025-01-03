package com.turing_machine.views;

import com.turing_machine.started_game.StartedGamePlayer;
import java.awt.Component;
import java.util.ArrayList;

public class GameWinnersPanel implements Displayable {

	private ArrayList<StartedGamePlayer> winners;

	public GameWinnersPanel(ArrayList<StartedGamePlayer> winners) {
        StartedGamePlayer player = winners.get(0);
        player.getNotes();
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
