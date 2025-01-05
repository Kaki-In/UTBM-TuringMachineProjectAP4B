package com.turing_machine.views;

import com.turing_machine.started_game.StartedGamePlayer;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameWinnersPanel extends Displayable {

	private final ArrayList<StartedGamePlayer> winners;

    private final JPanel panel;

	public GameWinnersPanel(ArrayList<StartedGamePlayer> winners) {
        this.winners = winners;

        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        JLabel win_label = new JLabel("Gagnants : ");
        win_label.setFont(Displayable.getFont(16).deriveFont(Font.BOLD));
        win_label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panel.add(win_label);

        for (StartedGamePlayer winner: this.winners)
        {
            JLabel winnerlabel = new JLabel(winner.getName());
            this.panel.add(winnerlabel);

        }

        if (this.winners.isEmpty())
        {
            JLabel lose_label = new JLabel("Aucun gagnant");
            lose_label.setForeground(new Color(100, 100, 100));
            this.panel.add(lose_label);
        }

        this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	}

    @Override
    public void refresh() {
    }

    @Override
    public JComponent getWidget() {
        return this.panel;
    }

}
