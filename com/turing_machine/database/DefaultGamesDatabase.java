package com.turing_machine.database;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CodeValue;
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
				System.err.println("Warning: DefaultGamesDatabase couldn't create the game numbered" + game_id);
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
			case 1, 7, 10, 15, 16, 19 -> first_component = CodeValue.TWO;
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
				criteria.add(new DefaultGameCriterion(4, 9));
				criteria.add(new DefaultGameCriterion(9, 46));
				criteria.add(new DefaultGameCriterion(11, 139));
				criteria.add(new DefaultGameCriterion(14, 118));
				break;

			case 2:
				criteria.add(new DefaultGameCriterion(3, 8));
				criteria.add(new DefaultGameCriterion(7, 39));
				criteria.add(new DefaultGameCriterion(10, 50));
				criteria.add(new DefaultGameCriterion(14, 117));
				break;
				
			case 3:
				criteria.add(new DefaultGameCriterion(4, 29));
				criteria.add(new DefaultGameCriterion(9, 48));
				criteria.add(new DefaultGameCriterion(13, 95));
				criteria.add(new DefaultGameCriterion(17, 85));
				break;
			
			case 4:
				criteria.add(new DefaultGameCriterion(3, 21));
				criteria.add(new DefaultGameCriterion(8, 40));
				criteria.add(new DefaultGameCriterion(15, 115));
				criteria.add(new DefaultGameCriterion(16, 132));
				break;
				
			case 5:
				criteria.add(new DefaultGameCriterion(2, 3));
				criteria.add(new DefaultGameCriterion(6, 35));
				criteria.add(new DefaultGameCriterion(14, 117));
				criteria.add(new DefaultGameCriterion(17, 86));
				break;
				
			case 6:
				criteria.add(new DefaultGameCriterion(2, 18));
				criteria.add(new DefaultGameCriterion(7, 36));
				criteria.add(new DefaultGameCriterion(10, 49));
				criteria.add(new DefaultGameCriterion(13, 141));
				break;
				
			case 7:
				criteria.add(new DefaultGameCriterion(8, 41));
				criteria.add(new DefaultGameCriterion(12, 93));
				criteria.add(new DefaultGameCriterion(15, 114));
				criteria.add(new DefaultGameCriterion(17, 86));
				break;
				
			case 8:
				criteria.add(new DefaultGameCriterion(3, 28));
				criteria.add(new DefaultGameCriterion(5, 34));
				criteria.add(new DefaultGameCriterion(9, 47));
				criteria.add(new DefaultGameCriterion(15, 113));
				criteria.add(new DefaultGameCriterion(16, 131));
				break;
				
			case 9:
				criteria.add(new DefaultGameCriterion(1, 16));
				criteria.add(new DefaultGameCriterion(7, 36));
				criteria.add(new DefaultGameCriterion(10, 51));
				criteria.add(new DefaultGameCriterion(12, 139));
				criteria.add(new DefaultGameCriterion(17, 87));
				break;
				
			case 10:
				criteria.add(new DefaultGameCriterion(2, 25));
				criteria.add(new DefaultGameCriterion(6, 35));
				criteria.add(new DefaultGameCriterion(8, 40));
				criteria.add(new DefaultGameCriterion(12, 90));
				criteria.add(new DefaultGameCriterion(15, 114));
				break;
				
			case 11:
				criteria.add(new DefaultGameCriterion(5, 37));
				criteria.add(new DefaultGameCriterion(10, 49));
				criteria.add(new DefaultGameCriterion(11, 92));
				criteria.add(new DefaultGameCriterion(15, 115));
				criteria.add(new DefaultGameCriterion(17, 86));
				break;
				
			case 12:
				criteria.add(new DefaultGameCriterion(4, 29));
				criteria.add(new DefaultGameCriterion(9, 46));
				criteria.add(new DefaultGameCriterion(18, 56));
				criteria.add(new DefaultGameCriterion(20, 119));
				break;
				
			case 13:
				criteria.add(new DefaultGameCriterion(11, 89));
				criteria.add(new DefaultGameCriterion(16, 132));
				criteria.add(new DefaultGameCriterion(19, 137));
				criteria.add(new DefaultGameCriterion(21, 81));
				break;
				
			case 14:
				criteria.add(new DefaultGameCriterion(2, 18));
				criteria.add(new DefaultGameCriterion(3, 28));
				criteria.add(new DefaultGameCriterion(17, 88));
				criteria.add(new DefaultGameCriterion(20, 120));
				break;
				
			case 15:
				criteria.add(new DefaultGameCriterion(5, 34));
				criteria.add(new DefaultGameCriterion(14, 114));
				criteria.add(new DefaultGameCriterion(18, 555));
				criteria.add(new DefaultGameCriterion(19, 136));
				criteria.add(new DefaultGameCriterion(20, 121));
				break;
				
			case 16:
				criteria.add(new DefaultGameCriterion(2, 25));
				criteria.add(new DefaultGameCriterion(7, 39));
				criteria.add(new DefaultGameCriterion(12, 140));
				criteria.add(new DefaultGameCriterion(16, 131));
				criteria.add(new DefaultGameCriterion(19, 100));
				criteria.add(new DefaultGameCriterion(22, 135));
				break;
				
			case 17:
				criteria.add(new DefaultGameCriterion(21, 82));
				criteria.add(new DefaultGameCriterion(31, 22));
				criteria.add(new DefaultGameCriterion(37, 103));
				criteria.add(new DefaultGameCriterion(39, 1));
				break;
				
			case 18:
				criteria.add(new DefaultGameCriterion(23, 67));
				criteria.add(new DefaultGameCriterion(28, 11));
				criteria.add(new DefaultGameCriterion(41, 29));
				criteria.add(new DefaultGameCriterion(48, 91));
				break;
				
			case 19:
				criteria.add(new DefaultGameCriterion(19, 136));
				criteria.add(new DefaultGameCriterion(24, 84));
				criteria.add(new DefaultGameCriterion(30, 14));
				criteria.add(new DefaultGameCriterion(31, 19));
				criteria.add(new DefaultGameCriterion(38, 105));
				break;
				
			case 20:
				criteria.add(new DefaultGameCriterion(11, 92));
				criteria.add(new DefaultGameCriterion(22, 135));
				criteria.add(new DefaultGameCriterion(30, 4));
				criteria.add(new DefaultGameCriterion(33, 39));
				criteria.add(new DefaultGameCriterion(34, 129));
				criteria.add(new DefaultGameCriterion(40, 31));
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

	public DefaultGame getRandomGame(GameDifficulty difficulty) {
		ArrayList<DefaultGame> corresponds_games = this.games.stream()
															 .filter(game -> game.getDifficulty() == difficulty)
															 .collect(Collectors.toCollection(ArrayList::new));

		return corresponds_games.get(Math.round((float) (Math.random() * corresponds_games.size())));
	}

}
