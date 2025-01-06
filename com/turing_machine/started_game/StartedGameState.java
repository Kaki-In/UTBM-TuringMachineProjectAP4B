package com.turing_machine.started_game;

import com.turing_machine.listeners.StartedGameStateListener;
import java.util.ArrayList;

public class StartedGameState
{
    
	private int round_id;

	private final StartedGameMachine machine;
	
	private final ArrayList<StartedGameStateListener> listeners;

    public StartedGameState(StartedGameMachine machine) {
        this.round_id = 0;
        this.machine = machine;
        this.listeners = new ArrayList<>(); 
    }

    public int getRoundId()
    {
        return this.round_id;
    }

    public StartedGameMachine getMachine()
    {
        return this.machine;
    }

	public void endRound() {
        ++ this.round_id;

        for (StartedGameStateListener listener: listeners)
        {
            listener.onNewRound(round_id );
        }
	}

    public void whenRoundChanged(StartedGameStateListener listener)
    {
        this.listeners.add(listener);
    }

}
