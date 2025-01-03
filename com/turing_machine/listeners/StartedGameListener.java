package com.turing_machine.listeners;

import com.turing_machine.started_game.StartedGamePlayer;
import java.util.ArrayList;

public interface StartedGameListener {

	public abstract void onNewRound(int round_id);

	public abstract void onGameEnds(ArrayList<StartedGamePlayer> winners);

}
