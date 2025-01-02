package com.turing_machine.database;

import com.turing_machine.exceptions.NoSuchCaseException;
import com.turing_machine.exceptions.NoSuchCriterionException;
import java.util.ArrayList;

public class CriteriaDatabase {

	private final ArrayList<Criterion> criteria;

	private final CriteriaCasesDatabase cases;

	protected CriteriaDatabase() {
		this.cases = new CriteriaCasesDatabase();
		this.criteria = new ArrayList<>();

		for (int i=1; i <= 48; ++i)
		{
			int[] cases_ids;
			try {
				cases_ids = getCasesIds(i);
			} catch (NoSuchCriterionException e) {
				System.err.println("Warning : CriteriaDatabase::getCasesIds(" + i + ") throwed a NoSuchCriterionException\n");
				continue;
			}

			ArrayList<CriterionCase> critera_cases = new ArrayList<>();
			for (int index = 0; index < cases_ids.length; ++index)
			{
				try {
					critera_cases.add(this.cases.getCriterionCase(cases_ids[index]));
				} catch (NoSuchCaseException a) {
					System.err.println("Warning : case " + cases_ids[index] + " has not been recognized");
				}
			}

			this.criteria.add(new Criterion(i, critera_cases));
		}
	}

	private static int[] getCasesIds(int criterion_id) throws NoSuchCriterionException
	{
		switch (criterion_id) {
			case 1:
				return new int[]{
					1, 16
				};

			case 2:
				return new int[]{
					25, 3, 18
				};

			case 3:
				return new int[]{
					28, 8, 21
				};

			case 4:
				return new int[]{
					29, 9, 10
				};

			case 5:
				return new int[]{
					34, 37
				};

			case 6:
				return new int[]{
					35, 38
				};

			case 7:
				return new int[]{
					36, 39
				};

			case 8:
				return new int[]{
					40, 41, 42, 400
				};

			case 9:
				return new int[]{
					46, 47, 48, 401
				};

			case 10:
				return new int[]{
					49, 50, 51, 402
				};

			case 11:
				return new int[]{
					139, 89, 92
				};

			case 12:
				return new int[]{
					140, 90, 93
				};

			case 13:
				return new int[]{
					141, 91, 95
				};

			case 14:
				return new int[]{
					116, 117, 118
				};

			case 15:
				return new int[]{
					113, 114, 115
				};

			case 16:
				return new int[]{
					132, 131
				};

			case 17:
				return new int[]{
					85, 86, 87, 88
				};

			case 18:
				return new int[]{
					55, 56
				};

			case 19:
				return new int[]{
					137, 100, 136
				};

			case 20:
				return new int[]{
					121, 120, 119
				};

			case 21:
				return new int[]{
					81, 82
				};

			case 22:
				return new int[]{
					133, 134, 135
				};

			case 23:
				return new int[]{
					74, 60, 67
				};

			case 24:
				return new int[]{
					83, 84, 403
				};

			case 25:
				return new int[]{
					122, 123, 124
				};

			case 26:
				return new int[]{
					25, 28, 31
				};

			case 27:
				return new int[]{
					26, 29, 32
				};

			case 28:
				return new int[]{
					1, 6, 11
				};

			case 29:
				return new int[]{
					3, 8, 13
				};

			case 30:
				return new int[]{
					4, 9,  14
				};

			case 31:
				return new int[]{
					16, 19, 22
				};

			case 32:
				return new int[]{
					18, 21, 24
				};

			case 33:
				return new int[]{
					34, 35, 36, 37, 38, 39
				};

			case 34:
				return new int[]{
					128, 129, 130
				};

			case 35:
				return new int[]{
					125, 126, 127
				};

			case 36:
				return new int[]{
					57, 58, 59
				};

			case 37:
				return new int[]{
					98, 103, 108
				};

			case 38:
				return new int[]{
					100, 105, 110
				};

			case 39:
				return new int[]{
					1, 6, 11, 16, 19, 22
				};

			case 40:
				return new int[]{
					25, 28, 31, 3, 8, 13, 18, 21, 24
				};

			case 41:
				return new int[]{
					26, 29, 32, 4, 9, 14, 142, 138, 143
				};

			case 42:
				return new int[]{
					116, 117, 118, 113, 114, 115
				};

			case 43:
				return new int[]{
					139, 89, 92, 140, 90, 93
				};

			case 44:
				return new int[]{
					144, 145, 94, 141, 91, 95
				};

			case 45:
				return new int[]{
					40, 41, 42, 46, 47, 48
				};

			case 46:
				return new int[]{
					46, 47, 48, 49, 50, 51
				};

			case 47:
				return new int[]{
					40, 41, 42, 49, 50, 51
				};

			case 48:
				return new int[]{
					139, 140, 141, 89, 90, 91, 92, 93, 94
				};

			default:
				throw new NoSuchCriterionException(criterion_id);
		}
	}

	public Criterion getCriterion(int id) throws NoSuchCriterionException {
		if (id > 48 || id <= 0)
		{
			throw new NoSuchCriterionException(id);
		}
		return this.criteria.get(id - 1);
	}

	public CriteriaCasesDatabase getCriteriaCases() {
		return this.cases;
	}

}
