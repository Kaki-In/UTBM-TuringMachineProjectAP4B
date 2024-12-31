package com.turing_machine.base_objects;

import java.util.InputMismatchException;

public enum CodeValue {

	ONE,
	TWO,
	THREE,
	FOUR,
	FIVE;

	public int getValue()
	{
		switch (this) {
			case CodeValue.ONE   : return 1;
			case CodeValue.TWO   : return 2;
			case CodeValue.THREE : return 3;
			case CodeValue.FOUR  : return 4;
			case CodeValue.FIVE  : return 5;
		}

		return -1; // this line can't be attained
	}

	public static CodeValue fromValue(int value) throws InputMismatchException
	{
		switch (value) {
			case 1:
				return ONE;
			case 2:
				return TWO;
			case 3:
				return THREE;
			case 4:
				return FOUR;
			case 5:
				return FIVE;
			default:
				throw new InputMismatchException("bad value given to create CodeValue");
		}
	}
}
