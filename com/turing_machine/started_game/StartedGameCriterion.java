package com.turing_machine.started_game;

import com.turing_machine.base_objects.Code;
import com.turing_machine.base_objects.CriterionLetter;
import com.turing_machine.database.CriteriaCasesDatabase;
import com.turing_machine.database.CriteriaDatabase;
import com.turing_machine.database.CriterionCase;
import com.turing_machine.database.Database;

public class StartedGameCriterion {

	private final int criterion_id;

	private final CriterionLetter letter;

	private final int good_case;

	public StartedGameCriterion(int criterion_id, CriterionLetter letter, int good_case) {
		this.criterion_id = criterion_id;
		this.letter = letter;
		this.good_case = good_case;
	}

	public int getCriterionId() {
		return this.criterion_id;
	}

	public CriterionLetter getLetter() {
		return this.letter;
	}

	public CriterionCase getGoodCase() {
		return Database.getCriteria().getCriteriaCases().getCriterionCase(this.good_case);
	}

	public boolean doesMatch(Code code, Code good_code)
	{
		CriteriaDatabase criteria_database = Database.getCriteria();
		CriteriaCasesDatabase cases_database = criteria_database.getCriteriaCases();

		if (this.criterion_id == 25)
		/* 
		il s'agit du critère symétrique "nombre de chiffres dans la suite croissants/décroissants", qui dépend du choix du 
		générateur de code. 

		L'intérêt de ce critère est d'obtenir deux cas (ordre ou pas ordre) et d'ajouter un troisième qui ne donne
		aucune information précise, contrairement à s'il y avait uniquement un cas "ordre" et un cas "pas d'ordre".

		Seuls le 2nd cas OU la connaissance des 1er et 3eme cas sont décisifs. 

		Toutefois, le 2nd cas permet directement de connaître si l'un des deux autres est validé, sachant qu'aucun des
		deux ne donne d'information supplémentaire. 
		*/
		{
			CriterionCase ascending_case 	= cases_database.getCriterionCase(133); // critère qui vérifie la croissance d'un code
			CriterionCase descending_case 	= cases_database.getCriterionCase(134); // critère qui vérifie la décroissance d'un code
			CriterionCase nothing_case 		= cases_database.getCriterionCase(135); // critère qui vérifie que le code ne suit aucune ordre

			boolean is_ascending = ascending_case.doesMatch(code);
			boolean is_descending = descending_case.doesMatch(code);

			boolean verifies_ascending = (good_case == 122 && is_descending || good_case == 124 && is_ascending);
			boolean verifies_descending = (good_case == 122 && is_ascending || good_case == 124 && is_descending);

			if (verifies_ascending)
			{
				return ascending_case.doesMatch(code);
			} else if (verifies_descending)
			{
				return descending_case.doesMatch(code);
			} else { // dans ce cas, le vrai code n'est ni croissant, ni décroissant, donc le code donné doit aussi ne suivre aucun ordre précis
				return nothing_case.doesMatch(code);
			}
		} else { // sinon, on se contente de vérifier si le critère s'applique bien au bon cas. Tous les autres critères sont normaux. 
			return this.getGoodCase().doesMatch(code);
		}
	}
}
