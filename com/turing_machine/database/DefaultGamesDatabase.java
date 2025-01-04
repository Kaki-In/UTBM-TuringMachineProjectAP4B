package com.turing_machine.database;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CodeValue;
import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.base_objects.GameCriteriaCount;
import com.turing_machine.base_objects.GameDifficulty;
import com.turing_machine.exceptions.NoSuchGameException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DefaultGamesDatabase {

	private final ArrayList<DefaultGame> games;

	protected DefaultGamesDatabase() {
		this.games = new ArrayList<>();

		for (int game_id=1; game_id <= 20; ++game_id)
		{
			try {
				this.games.add(
					new DefaultGame(
						getGameCode(game_id),
						getGameCriteria(game_id),
						getGameDifficulty(game_id)
					)
				);

			} catch (NoSuchGameException e)
			{
				System.err.println("Warning: DefaultGamesDatabase couldn't create the game numbered " + game_id + " (" + e.getMessage() + ")");
			}
		}
	}

	private Code getGameCode(int game_id) throws NoSuchGameException
	{
		CodeValue first_component;
		CodeValue second_component;
		CodeValue third_component;
		
		switch (game_id) {
			case 12, 13, 17 -> first_component = CodeValue.ONE;
			case 1, 7, 10, 14, 15, 16, 19 -> first_component = CodeValue.TWO;
			case 3, 4, 5, 9, 11, 18 -> first_component = CodeValue.THREE;
			case 2, 8, 20 -> first_component = CodeValue.FOUR;
			case 6 -> first_component = CodeValue.FIVE;
			
			default -> throw new NoSuchGameException(game_id);
		}

		switch (game_id) {
			case 6, 12, 13, 20 -> second_component = CodeValue.ONE;
			case 8, 11, 14, 19 -> second_component = CodeValue.TWO;
			case 2, 3, 17, 18 -> second_component = CodeValue.THREE;
			case 1, 4, 7, 9, 10, 16 -> second_component = CodeValue.FOUR;
			case 5, 15 -> second_component = CodeValue.FIVE;
			
			default -> throw new NoSuchGameException(game_id);
		}

		switch (game_id) {
			case 1, 3, 7, 12, 13, 18, 20 -> third_component = CodeValue.ONE;
			case 6, 10, 14 -> third_component = CodeValue.TWO;
			case 8, 15, 16, 17 -> third_component = CodeValue.THREE;
			case 5, 9, 19 -> third_component = CodeValue.FOUR;
			case 2, 4, 11 -> third_component = CodeValue.FIVE;
			
			default -> throw new NoSuchGameException(game_id);
		}

		return new Code(first_component, second_component, third_component);
	}

	private ArrayList<DefaultGameCriterion> getGameCriteria(int game_id) throws NoSuchGameException
	{
		ArrayList<DefaultGameCriterion> criteria = new ArrayList<>();

		switch (game_id) {
			case 1:
				criteria.add(new DefaultGameCriterion(4, CriterionLetter.A, 9));
				criteria.add(new DefaultGameCriterion(9, CriterionLetter.B, 46));
				criteria.add(new DefaultGameCriterion(11, CriterionLetter.C, 139));
				criteria.add(new DefaultGameCriterion(14, CriterionLetter.D, 118));
				break;

			case 2:
				criteria.add(new DefaultGameCriterion(3, CriterionLetter.A, 8));
				criteria.add(new DefaultGameCriterion(7, CriterionLetter.B, 39));
				criteria.add(new DefaultGameCriterion(10, CriterionLetter.C, 50));
				criteria.add(new DefaultGameCriterion(14, CriterionLetter.D, 117));
				break;
				
			case 3:
				criteria.add(new DefaultGameCriterion(4, CriterionLetter.A, 29));
				criteria.add(new DefaultGameCriterion(9, CriterionLetter.B, 48));
				criteria.add(new DefaultGameCriterion(13, CriterionLetter.C, 95));
				criteria.add(new DefaultGameCriterion(17, CriterionLetter.D, 85));
				break;
			
			case 4:
				criteria.add(new DefaultGameCriterion(3, CriterionLetter.A, 21));
				criteria.add(new DefaultGameCriterion(8, CriterionLetter.B, 40));
				criteria.add(new DefaultGameCriterion(15, CriterionLetter.C, 115));
				criteria.add(new DefaultGameCriterion(16, CriterionLetter.D, 132));
				break;
				
			case 5:
				criteria.add(new DefaultGameCriterion(2, CriterionLetter.A, 3));
				criteria.add(new DefaultGameCriterion(6, CriterionLetter.B, 35));
				criteria.add(new DefaultGameCriterion(14, CriterionLetter.C, 117));
				criteria.add(new DefaultGameCriterion(17, CriterionLetter.D, 86));
				break;
				
			case 6:
				criteria.add(new DefaultGameCriterion(2, CriterionLetter.A, 18));
				criteria.add(new DefaultGameCriterion(7, CriterionLetter.B, 36));
				criteria.add(new DefaultGameCriterion(10, CriterionLetter.C, 49));
				criteria.add(new DefaultGameCriterion(13, CriterionLetter.D, 141));
				break;
				
			case 7:
				criteria.add(new DefaultGameCriterion(8, CriterionLetter.A, 41));
				criteria.add(new DefaultGameCriterion(12, CriterionLetter.B, 93));
				criteria.add(new DefaultGameCriterion(15, CriterionLetter.C, 114));
				criteria.add(new DefaultGameCriterion(17, CriterionLetter.D, 86));
				break;
				
			case 8:
				criteria.add(new DefaultGameCriterion(3, CriterionLetter.A, 28));
				criteria.add(new DefaultGameCriterion(5, CriterionLetter.B, 34));
				criteria.add(new DefaultGameCriterion(9, CriterionLetter.C, 47));
				criteria.add(new DefaultGameCriterion(15, CriterionLetter.D, 113));
				criteria.add(new DefaultGameCriterion(16, CriterionLetter.E, 131));
				break;
				
			case 9:
				criteria.add(new DefaultGameCriterion(1, CriterionLetter.A, 16));
				criteria.add(new DefaultGameCriterion(7, CriterionLetter.B, 36));
				criteria.add(new DefaultGameCriterion(10, CriterionLetter.C, 51));
				criteria.add(new DefaultGameCriterion(12, CriterionLetter.D, 139));
				criteria.add(new DefaultGameCriterion(17, CriterionLetter.E, 87));
				break;
				
			case 10:
				criteria.add(new DefaultGameCriterion(2, CriterionLetter.A, 25));
				criteria.add(new DefaultGameCriterion(6, CriterionLetter.B, 35));
				criteria.add(new DefaultGameCriterion(8, CriterionLetter.C, 40));
				criteria.add(new DefaultGameCriterion(12, CriterionLetter.D, 90));
				criteria.add(new DefaultGameCriterion(15, CriterionLetter.E, 114));
				break;
				
			case 11:
				criteria.add(new DefaultGameCriterion(5, CriterionLetter.A, 37));
				criteria.add(new DefaultGameCriterion(10, CriterionLetter.B, 49));
				criteria.add(new DefaultGameCriterion(11, CriterionLetter.C, 92));
				criteria.add(new DefaultGameCriterion(15, CriterionLetter.D, 115));
				criteria.add(new DefaultGameCriterion(17, CriterionLetter.E, 86));
				break;
				
			case 12:
				criteria.add(new DefaultGameCriterion(4, CriterionLetter.A, 29));
				criteria.add(new DefaultGameCriterion(9, CriterionLetter.B, 46));
				criteria.add(new DefaultGameCriterion(18, CriterionLetter.C, 56));
				criteria.add(new DefaultGameCriterion(20, CriterionLetter.D, 119));
				break;
				
			case 13:
				criteria.add(new DefaultGameCriterion(11, CriterionLetter.A, 89));
				criteria.add(new DefaultGameCriterion(16, CriterionLetter.B, 132));
				criteria.add(new DefaultGameCriterion(19, CriterionLetter.C, 137));
				criteria.add(new DefaultGameCriterion(21, CriterionLetter.D, 81));
				break;
				
			case 14:
				criteria.add(new DefaultGameCriterion(2, CriterionLetter.A, 18));
				criteria.add(new DefaultGameCriterion(3, CriterionLetter.B, 28));
				criteria.add(new DefaultGameCriterion(17, CriterionLetter.C, 88));
				criteria.add(new DefaultGameCriterion(20, CriterionLetter.D, 120));
				break;
				
			case 15:
				criteria.add(new DefaultGameCriterion(5, CriterionLetter.A, 34));
				criteria.add(new DefaultGameCriterion(14, CriterionLetter.B, 114));
				criteria.add(new DefaultGameCriterion(18, CriterionLetter.C, 555));
				criteria.add(new DefaultGameCriterion(19, CriterionLetter.D, 136));
				criteria.add(new DefaultGameCriterion(20, CriterionLetter.E, 121));
				break;
				
			case 16:
				criteria.add(new DefaultGameCriterion(2, CriterionLetter.A, 25));
				criteria.add(new DefaultGameCriterion(7, CriterionLetter.B, 39));
				criteria.add(new DefaultGameCriterion(12, CriterionLetter.C, 140));
				criteria.add(new DefaultGameCriterion(16, CriterionLetter.D, 131));
				criteria.add(new DefaultGameCriterion(19, CriterionLetter.E, 100));
				criteria.add(new DefaultGameCriterion(22, CriterionLetter.F, 135));
				break;
				
			case 17:
				criteria.add(new DefaultGameCriterion(21, CriterionLetter.A, 82));
				criteria.add(new DefaultGameCriterion(31, CriterionLetter.B, 22));
				criteria.add(new DefaultGameCriterion(37, CriterionLetter.C, 103));
				criteria.add(new DefaultGameCriterion(39, CriterionLetter.D, 1));
				break;
				
			case 18:
				criteria.add(new DefaultGameCriterion(23, CriterionLetter.A, 67));
				criteria.add(new DefaultGameCriterion(28, CriterionLetter.B, 11));
				criteria.add(new DefaultGameCriterion(41, CriterionLetter.C, 29));
				criteria.add(new DefaultGameCriterion(48, CriterionLetter.D, 91));
				break;
				
			case 19:
				criteria.add(new DefaultGameCriterion(19, CriterionLetter.A, 136));
				criteria.add(new DefaultGameCriterion(24, CriterionLetter.B, 84));
				criteria.add(new DefaultGameCriterion(30, CriterionLetter.C, 14));
				criteria.add(new DefaultGameCriterion(31, CriterionLetter.D, 19));
				criteria.add(new DefaultGameCriterion(38, CriterionLetter.E, 105));
				break;
				
			case 20:
				criteria.add(new DefaultGameCriterion(11, CriterionLetter.A, 92));
				criteria.add(new DefaultGameCriterion(22, CriterionLetter.B, 135));
				criteria.add(new DefaultGameCriterion(30, CriterionLetter.C, 4));
				criteria.add(new DefaultGameCriterion(33, CriterionLetter.D, 39));
				criteria.add(new DefaultGameCriterion(34, CriterionLetter.E, 129));
				criteria.add(new DefaultGameCriterion(40, CriterionLetter.F, 31));
				break;
				
			default:
				throw new NoSuchGameException(game_id);
		}

		return criteria;
	}

	private GameDifficulty getGameDifficulty(int game_id) throws NoSuchGameException
	{
		if (game_id < 1 || game_id > 20)
		{
			throw new NoSuchGameException(game_id);
		}

		if (game_id < 12)
		{
			return GameDifficulty.EASY;
		}
		
		if (game_id < 17)
		{
			return GameDifficulty.STANDARD;
		}

		return GameDifficulty.HARD;
	}

	public int size()
	{
		return this.games.size();
	}

	public DefaultGame getGame(int index) {
		return this.games.get(index);
	}

	public DefaultGame getRandomGame(GameDifficulty difficulty, GameCriteriaCount criteriaCount) {
		ArrayList<DefaultGame> corresponds_games = this.games.stream()
															 .filter(game -> game.getDifficulty() == difficulty && game.getCriteriaCount() == criteriaCount)
															 .collect(Collectors.toCollection(ArrayList::new));

		return corresponds_games.get(Math.round((float) (Math.random() * (corresponds_games.size() - 1))));
	}

}
