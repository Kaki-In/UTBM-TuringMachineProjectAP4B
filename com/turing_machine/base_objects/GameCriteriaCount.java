package com.turing_machine.base_objects;

import java.util.InputMismatchException;

public enum GameCriteriaCount {

	FOUR_CRITERIA,
	FIVE_CRITERIA,
	SIX_CRITERIA;
	
	public int toInteger()
	{
		switch (this) {
			case GameCriteriaCount.FOUR_CRITERIA: return 4;
			case GameCriteriaCount.FIVE_CRITERIA: return 5;
			case GameCriteriaCount.SIX_CRITERIA : return 6;
		}

		return -1; // this line can't be attained
	}

	public static GameCriteriaCount fromInteger(int value) throws InputMismatchException
	{
		switch (value) {
			case 4:
				return FOUR_CRITERIA;
			case 5:
				return FIVE_CRITERIA;
			case 6:
				return SIX_CRITERIA;
			default:
				throw new InputMismatchException("bad value given to create GameCriteriaCount");
		}
	}
}
