package com.turing_machine.views;

import com.turing_machine.started_game.StartedGamePlayer;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameWinnersPanel extends Displayable {

	private final ArrayList<StartedGamePlayer> winners;

    private final JPanel panel;

	public GameWinnersPanel(ArrayList<StartedGamePlayer> winners) {
        this.winners = winners;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        for (StartedGamePlayer winner: this.winners)
        {
            this.panel.add(new JLabel(winner.getName()));
        }
	}

    @Override
    public void refresh() {
    }

    @Override
    public Component getWidget() {
        return this.panel;
    }

}
