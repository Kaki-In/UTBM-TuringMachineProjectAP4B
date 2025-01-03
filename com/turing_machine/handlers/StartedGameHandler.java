package com.turing_machine.handlers;

import com.turing_machine.exceptions.NotStartedGameException;
import com.turing_machine.listeners.StartedGameListener;
import com.turing_machine.platform_state.GameDebriefingStep;
import com.turing_machine.platform_state.MainPlatformState;
import com.turing_machine.platform_state.PlatformStep;
import com.turing_machine.platform_state.StartedGameStep;
import com.turing_machine.started_game.StartedGamePlayer;
import java.util.ArrayList;

public class StartedGameHandler extends PlatformHandler {

	public StartedGameHandler(MainPlatformState state ) {
		super(state);

		state.whenPlatformStepChanged((PlatformStep last_step, PlatformStep new_step) -> {
			if (new_step instanceof StartedGameStep game_step)
			{
				game_step.getStartedGame().whenRoundChanged(new StartedGameListener() {
					@Override
					public void onNewRound(int round_id) {}

					@Override
					public void onGameEnds(ArrayList<StartedGamePlayer> winners) {
						try 
						{
							endGame(winners);
						} catch (NotStartedGameException e) {
							System.err.println("Warning: game not started when it ends");
						}
					}

				});
			}
		});
	}

	public void endGame(ArrayList<StartedGamePlayer> winners) throws NotStartedGameException {
		MainPlatformState state = getState();

		if (!(state.getActualStep() instanceof StartedGameStep game_step))
		{
			throw new NotStartedGameException();
		}

		state.setActualStep(new GameDebriefingStep(winners, game_step.getStartedGame().getMachine()));
	}

}
