package com.turing_machine.base_objects;

import java.util.InputMismatchException;

public enum CriterionLetter {

	A,
	B,
	C,
	D,
	E,
	F;

	public int getValue()
	{
		switch (this) {
			case CriterionLetter.A : return 1;
			case CriterionLetter.B : return 2;
			case CriterionLetter.C : return 3;
			case CriterionLetter.D : return 4;
			case CriterionLetter.E : return 5;
			case CriterionLetter.F : return 6;
		}

		return -1; // this line can't be attained
	}

	public static CriterionLetter fromValue(int value) throws InputMismatchException
	{
		switch (value) {
			case 1:
				return A;
			case 2:
				return B;
			case 3:
				return C;
			case 4:
				return D;
			case 5:
				return E;
			case 6:
				return F;
			default:
				throw new InputMismatchException("bad value given to create CriterionLetter");
		}
	}
}
