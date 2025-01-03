package com.turing_machine.database;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CodeIndex;
import com.turing_machine.base_objects.CodeValue;
import com.turing_machine.exceptions.NoSuchCaseException;
import java.util.ArrayList;

public class CriteriaCasesDatabase {

	private ArrayList<CriterionCase> cases;

	protected CriteriaCasesDatabase() {
		this.cases = new ArrayList<>();

		/*

			Construction des différents cas possibles

			La numérotation est effectuée dans un souci de compatibilité avec l'API distante de Turing Machine. 

			Pour avoir une liste complète et visuelle des cas, il est possible d'effectuer le script python suivant : 

				import requests

				for i in range(1, 150):
					try:
						image = requests.get(f"https://turingmachine.info/images/laws/FR/{i}_Mini_FR.jpg")
						image.raise_for_status()
					except Exception:
						continue
					else:
						a = open(f"./image{i}.jpg", "wb")
						written_length = a.write(image.content)
						a.close()
				

		*/

		this.cases.add(
			new CriterionCase(1, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) == CodeValue.ONE;
			})
		);

		this.cases.add(
			new CriterionCase(3, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) == CodeValue.THREE;
			})
		);

		this.cases.add(
			new CriterionCase(4, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) == CodeValue.FOUR;
			})
		);

		this.cases.add(
			new CriterionCase(5, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) == CodeValue.FIVE;
			})
		);

		this.cases.add(
			new CriterionCase(6, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) == CodeValue.ONE;
			})
		);

		this.cases.add(
			new CriterionCase(8, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) == CodeValue.THREE;
			})
		);

		this.cases.add(
			new CriterionCase(9, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) == CodeValue.FOUR;
			})
		);

		this.cases.add(
			new CriterionCase(10, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) == CodeValue.FIVE;
			})
		);

		this.cases.add(
			new CriterionCase(11, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE) == CodeValue.ONE;
			})
		);

		this.cases.add(
			new CriterionCase(13, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE) == CodeValue.THREE;
			})
		);

		this.cases.add(
			new CriterionCase(14, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE) == CodeValue.FOUR;
			})
		);

		this.cases.add(
			new CriterionCase(15, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE) == CodeValue.FIVE;
			})
		);

		this.cases.add(
			new CriterionCase(16, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() > 1;
			})
		);

		this.cases.add(
			new CriterionCase(18, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() > 3;
			})
		);

		this.cases.add(
			new CriterionCase(19, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() > 1;
			})
		);

		this.cases.add(
			new CriterionCase(21, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() > 3;
			})
		);

		this.cases.add(
			new CriterionCase(22, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() > 1;
			})
		);

		this.cases.add(
			new CriterionCase(24, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() > 3;
			})
		);

		this.cases.add(
			new CriterionCase(25, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() < 3;
			})
		);

		this.cases.add(
			new CriterionCase(26, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() < 4;
			})
		);

		this.cases.add(
			new CriterionCase(28, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() < 3;
			})
		);

		this.cases.add(
			new CriterionCase(29, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() < 4;
			})
		);

		this.cases.add(
			new CriterionCase(31, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() < 3;
			})
		);

		this.cases.add(
			new CriterionCase(32, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() < 4;
			})
		);

		this.cases.add(
			new CriterionCase(34, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() % 2 == 0;
			})
		);

		this.cases.add(
			new CriterionCase(35, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() % 2 == 0;
			})
		);

		this.cases.add(
			new CriterionCase(36, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() % 2 == 0;
			})
		);

		this.cases.add(
			new CriterionCase(37, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() % 2 == 1;
			})
		);

		this.cases.add(
			new CriterionCase(38, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() % 2 == 1;
			})
		);

		this.cases.add(
			new CriterionCase(39, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() % 2 == 1;
			})
		);

		this.cases.add(
			new CriterionCase(40, (Code code) -> {
				return code.count(CodeValue.ONE) == 0;
			})
		);

		this.cases.add(
			new CriterionCase(41, (Code code) -> {
				return code.count(CodeValue.ONE) == 1;
			})
		);

		this.cases.add(
			new CriterionCase(42, (Code code) -> {
				return code.count(CodeValue.ONE) == 2;
			})
		);

		this.cases.add(
			new CriterionCase(46, (Code code) -> {
				return code.count(CodeValue.THREE) == 0;
			})
		);

		this.cases.add(
			new CriterionCase(47, (Code code) -> {
				return code.count(CodeValue.THREE) == 1;
			})
		);

		this.cases.add(
			new CriterionCase(48, (Code code) -> {
				return code.count(CodeValue.THREE) == 2;
			})
		);

		this.cases.add(
			new CriterionCase(49, (Code code) -> {
				return code.count(CodeValue.FOUR) == 0;
			})
		);

		this.cases.add(
			new CriterionCase(50, (Code code) -> {
				return code.count(CodeValue.FOUR) == 1;
			})
		);

		this.cases.add(
			new CriterionCase(51, (Code code) -> {
				return code.count(CodeValue.FOUR) == 2;
			})
		);

		this.cases.add(
			new CriterionCase(55, (Code code) -> {
				return code.sum() % 2 == 0;
			})
		);

		this.cases.add(
			new CriterionCase(56, (Code code) -> {
				return code.sum() % 2 == 1;
			})
		);

		this.cases.add(
			new CriterionCase(57, (Code code) -> {
				return code.sum() % 3 == 0 && code.sum() % 4 != 0 && code.sum() % 5 != 0;
			})
		);

		this.cases.add(
			new CriterionCase(58, (Code code) -> {
				return code.sum() % 3 != 0 && code.sum() % 4 == 0 && code.sum() % 5 != 0;
			})
		);

		this.cases.add(
			new CriterionCase(59, (Code code) -> {
				return code.sum() % 3 != 0 && code.sum() % 4 != 0 && code.sum() % 5 == 0;
			})
		);

		this.cases.add(
			new CriterionCase(60, (Code code) -> {
				return code.sum() == 6;
			})
		);

		this.cases.add(
			new CriterionCase(67, (Code code) -> {
				return code.sum() > 6;
			})
		);

		this.cases.add(
			new CriterionCase(74, (Code code) -> {
				return code.sum() < 6;
			})
		);

		this.cases.add(
			new CriterionCase(81, (Code code) -> {
				if (code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) != code.getValue(CodeIndex.SECOND_YELLOW_SQUARE)
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) != code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE)
					&& code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE) != code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE))
				{
					return true; // all are different
				} else if (code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) != code.getValue(CodeIndex.SECOND_YELLOW_SQUARE)
						|| code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) != code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE)
						|| code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE) != code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE))
				{
					return false; // two only are different
				} else {
					return true; // three are same
				}
			})
		);

		this.cases.add(
			new CriterionCase(82, (Code code) -> {
				if (code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) != code.getValue(CodeIndex.SECOND_YELLOW_SQUARE)
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) != code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE)
					&& code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE) != code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE))
				{
					return false; // all are different
				} else if (code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) != code.getValue(CodeIndex.SECOND_YELLOW_SQUARE)
						|| code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) != code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE)
						|| code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE) != code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE))
				{
					return true; // two only are different
				} else {
					return false; // three are same
				}
			})
		);

		this.cases.add(
			new CriterionCase(83, (Code code) -> {
				int first = code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger();
				int second = code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
				int third = code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();

				return first <= second && second <= third;
			})
		);

		this.cases.add(
			new CriterionCase(84, (Code code) -> {
				int first = code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger();
				int second = code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
				int third = code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();

				return first >= second && second <= third
					|| first <= second && second >= third;
			})
		);

		this.cases.add(
			new CriterionCase(85, (Code code) -> {
				int first = code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger();
				int second = code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
				int third = code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();

				return first%2+second%2+third%2 == 3;
			})
		);

		this.cases.add(
			new CriterionCase(86, (Code code) -> {
				int first = code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger();
				int second = code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
				int third = code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();

				return first%2+second%2+third%2 == 2;
			})
		);

		this.cases.add(
			new CriterionCase(87, (Code code) -> {
				int first = code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger();
				int second = code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
				int third = code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();

				return first%2+second%2+third%2 == 1;
			})
		);

		this.cases.add(
			new CriterionCase(88, (Code code) -> {
				int first = code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger();
				int second = code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
				int third = code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();

				return first%2+second%2+third%2 == 0;
			})
		);

		this.cases.add(
			new CriterionCase(89, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) == code.getValue(CodeIndex.SECOND_YELLOW_SQUARE);
			})
		);

		this.cases.add(
			new CriterionCase(90, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) == code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE);
			})
		);

		this.cases.add(
			new CriterionCase(91, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) == code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE);
			})
		);

		this.cases.add(
			new CriterionCase(92, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() > code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(93, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() > code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(94, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() > code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(95, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() > code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(96, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() > code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(97, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() > code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(98, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() + code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() == 4;
			})
		);

		this.cases.add(
			new CriterionCase(100, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() + code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() == 6;
			})
		);

		this.cases.add(
			new CriterionCase(103, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() + code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() == 4;
			})
		);

		this.cases.add(
			new CriterionCase(105, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() + code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() == 6;
			})
		);

		this.cases.add(
			new CriterionCase(108, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() + code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() == 4;
			})
		);

		this.cases.add(
			new CriterionCase(110, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() + code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() == 6;
			})
		);

		this.cases.add(
			new CriterionCase(113, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() > code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger()
					&& code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() > code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(114, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() > code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger()
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() > code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(115, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() > code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger()
					&& code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() > code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(116, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() < code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger()
					&& code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() < code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(117, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() < code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger()
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() < code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(118, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() < code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger()
					&& code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() < code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(119, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() == code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger()
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() == code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(120, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) == code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) && code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) != code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE)
					|| code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE) != code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) && code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) == code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE);
			})
		);

		this.cases.add(
			new CriterionCase(121, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() != code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger()
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() != code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(122, (Code code) -> {
				return false; // uses specific implementation (see the criterion number 25 in CriteriaDatabase.java to know more)
			})
		);

		this.cases.add(
			new CriterionCase(123, (Code code) -> {
				return false; // uses specific implementations (see the criterion number 25 in CriteriaDatabase.java to know more)
			})
		);

		this.cases.add(
			new CriterionCase(124, (Code code) -> {
				return false; // uses specific implementations (see the criterion number 25 in CriteriaDatabase.java to know more)
			})
		);

		this.cases.add(
			new CriterionCase(125, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() >= code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger()
					&& code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() >= code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(126, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() >= code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger()
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() >= code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(127, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() >= code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger()
					&& code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() >= code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(128, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() <= code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger()
					&& code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() <= code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(129, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() <= code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger()
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() <= code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(130, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() <= code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger()
					&& code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() <= code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(131, (Code code) -> {
				return code.count(CodeValue.ONE) + code.count(CodeValue.THREE) + code.count(CodeValue.FIVE) < code.count(CodeValue.TWO) + code.count(CodeValue.FOUR);
			})
		);

		this.cases.add(
			new CriterionCase(132, (Code code) -> {
				return code.count(CodeValue.ONE) + code.count(CodeValue.THREE) + code.count(CodeValue.FIVE) > code.count(CodeValue.TWO) + code.count(CodeValue.FOUR);
			})
		);

		this.cases.add(
			new CriterionCase(133, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() < code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger()
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() < code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(134, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() > code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger()
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() > code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(135, (Code code) -> {
				try {
					CriterionCase case133 = this.getCriterionCase(133);
					CriterionCase case134 = this.getCriterionCase(134);

					return !(case133.doesMatch(code) || case134.doesMatch(code));
				} catch (NoSuchCaseException e)
				{
					System.err.println("Warning: criterion cases 133 and/or 134 not recognized");
					return false;
				}
			})
		);

		this.cases.add(
			new CriterionCase(136, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() + code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() > 6;
			})
		);

		this.cases.add(
			new CriterionCase(137, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() + code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() < 6;
			})
		);

		this.cases.add(
			new CriterionCase(138, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() > 4;
			})
		);

		this.cases.add(
			new CriterionCase(139, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() < code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger();
			})
		);

		this.cases.add(
			new CriterionCase(140, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() < code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);
		
		this.cases.add(
			new CriterionCase(141, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() < code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);
		
		this.cases.add(
			new CriterionCase(142, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() > 4;
			})
		);
		
		this.cases.add(
			new CriterionCase(143, (Code code) -> {
				return code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger() > 4;
			})
		);
		
		this.cases.add(
			new CriterionCase(144, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() < code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger();
			})
		);
		
		this.cases.add(
			new CriterionCase(145, (Code code) -> {
				return code.getValue(CodeIndex.SECOND_YELLOW_SQUARE) == code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE);
			})
		);

		// The following cases were not found among the api used cases
		
		this.cases.add(
			new CriterionCase(400, (Code code) -> {
				return code.count(CodeValue.ONE) == 3;
			})
		);
		
		this.cases.add(
			new CriterionCase(401, (Code code) -> {
				return code.count(CodeValue.THREE) == 3;
			})
		);
		
		this.cases.add(
			new CriterionCase(402, (Code code) -> {
				return code.count(CodeValue.FOUR) == 3;
			})
		);
		
		this.cases.add(
			new CriterionCase(403, (Code code) -> {
				return code.getValue(CodeIndex.FIRST_BLUE_TRIANGLE).toInteger() < code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger()
					&& code.getValue(CodeIndex.SECOND_YELLOW_SQUARE).toInteger() < code.getValue(CodeIndex.THIRD_PURPLE_CIRCLE).toInteger();
			})
		);
	}

	public CriterionCase getCriterionCase(int id) throws NoSuchCaseException
	{

		for (CriterionCase criterion_case: this.cases)
		{
			if (criterion_case.getId() == id) return criterion_case;
		}

		throw new NoSuchCaseException(id);
	}

}
