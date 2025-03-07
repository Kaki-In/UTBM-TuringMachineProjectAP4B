package com.turing_machine.handlers;

import com.turing_machine.database.CriterionCase;
import com.turing_machine.database.Database;
import com.turing_machine.exceptions.NoSuchCriterionException;
import com.turing_machine.started_game.StartedGameCriterion;
import com.turing_machine.started_game.StartedGamePlayerCriteria;
import com.turing_machine.started_game.StartedGamePlayerCriterion;
import com.turing_machine.started_game.StartedGamePlayerCriterionCase;
import com.turing_machine.started_game.StartedGamePlayerNotes;
import com.turing_machine.started_game.StartedGameState;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GamePlayerNotesBuilder {

	public StartedGamePlayerNotes createPlayerNotes(StartedGameState state) {
		StartedGamePlayerCriteria criteria = new StartedGamePlayerCriteria(
			state.getMachine().getCriteria().getCriteria().stream()
											   .map(criterion -> createPlayerCriterion(criterion))
											   .collect(Collectors.toCollection(ArrayList::new))
		);
		return new StartedGamePlayerNotes(criteria, state);
	}

	public StartedGamePlayerCriterion createPlayerCriterion(StartedGameCriterion criterion)
	{
		int criterion_id = criterion.getCriterionId();

		try {
			ArrayList<CriterionCase> cases = Database.getCriteria().getCriterion(criterion_id).getDistinctCases();

			return new StartedGamePlayerCriterion(criterion.getCriterionId(), criterion.getLetter(),
				cases.stream()
					 .map(distinct_case -> new StartedGamePlayerCriterionCase(distinct_case.getId()))
					 .collect(Collectors.toCollection(ArrayList::new))
			);
		} catch (NoSuchCriterionException e) {
			System.err.println("Warning : criterion " + criterion_id + " couldn't be recognized");
			return null;
		}

	}

}
