package com.turing_machine.base_objects;

import java.util.InputMismatchException;

public enum CodeIndex {

	FIRST_BLUE_TRIANGLE,
	SECOND_YELLOW_SQUARE,
	THIRD_PURPLE_CIRCLE,;

	public int toInteger()
	{
		switch (this) {
			case CodeIndex.FIRST_BLUE_TRIANGLE  : return 1;
			case CodeIndex.SECOND_YELLOW_SQUARE : return 2;
			case CodeIndex.THIRD_PURPLE_CIRCLE  : return 3;
		}

		return -1; // this line can't be attained
	}

	public static CodeIndex fromInteger(int value) throws InputMismatchException
	{
		switch (value) {
			case 1:
				return FIRST_BLUE_TRIANGLE;
			case 2:
				return SECOND_YELLOW_SQUARE;
			case 3:
				return THIRD_PURPLE_CIRCLE;
			default:
				throw new InputMismatchException("bad value given to create CodeIndex");
		}
	}

}
