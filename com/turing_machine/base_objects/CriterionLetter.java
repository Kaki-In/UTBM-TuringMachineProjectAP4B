package com.turing_machine.base_objects;

import java.util.InputMismatchException;

public enum CriterionLetter {

	A,
	B,
	C,
	D,
	E,
	F;

	public int toInteger()
	{
		switch (this) {
			case CriterionLetter.A : return 0;
			case CriterionLetter.B : return 1;
			case CriterionLetter.C : return 2;
			case CriterionLetter.D : return 3;
			case CriterionLetter.E : return 4;
			case CriterionLetter.F : return 5;
		}

		return -1; // this line can't be attained
	}

	public static CriterionLetter fromInteger(int value) throws InputMismatchException
	{
		switch (value) {
			case 0:
				return A;
			case 1:
				return B;
			case 2:
				return C;
			case 3:
				return D;
			case 4:
				return E;
			case 5:
				return F;
			default:
				throw new InputMismatchException("bad value given to create CriterionLetter");
		}
	}
}
