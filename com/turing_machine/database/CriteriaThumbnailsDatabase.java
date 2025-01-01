package com.turing_machine.database;

import com.turing_machine.exceptions.NoSuchCriterionException;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class CriteriaThumbnailsDatabase {

	private ArrayList<CriterionThumbnail> criteria;

	protected CriteriaThumbnailsDatabase() {
		this.criteria = new ArrayList<>();

		this.criteria.add(
			new CriterionThumbnail(1, "le premier nombre comparé à 1", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(2, "le premier nombre comparé à 3", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(3, "le deuxième nombre comparé à 3", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(4, "le deuxième nombre comparé à 4", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(5, "si le premier nombre est pair ou impair", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(6, "si le deuxième nombre est pair ou impair", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(7, "si le troisième nombre est pair ou impair", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(8, "le nombre de 1 dans le code", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(9, "le nombre de 3 dans le code", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(10, "le nombre de 4 dans le code", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(11, "le premier nombre comparé au deuxième", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(12, "le premier nombre comparé au troisième", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(13, "le deuxième nombre comparé au troisième", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(14, "quel nombre est plus petit que les autres", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(15, "quel nombre est plus grand que les autres", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(16, "le nombre de nombres pairs comparés au nombre de nombres impairs", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(17, "le nombre de nombre pairs dans le code", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(18, "si la somme des 3 nombres est paire ou impaire", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(19, "la somme du premier et deuxième nombres comparée à 6", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(20, "si un nombre se répète dans le code", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(21, "s'il y a des jumeaux (non triplés)", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(22, "si les 3 nombres sont dans l'ordre croissant, décroissant ou non ordonnés", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(23, "la somme de tous les nombres comparée à 6", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(24, "s'il y a une séquence de nombres croissants", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(25, "s'il y a une séquence de nombres croissants ou décroissants", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(26, "qu'une couleur spécifique est plus petite que 3", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(27, "qu'une couleur spécifique est plus petite que 4", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(28, "qu'une couleur spécifique est égale à 1", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(29, "qu'une couleur spécifique est égale à 3", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(30, "qu'une couleur spécifique est égale à 4", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(31, "qu'une couleur spécifique est supérieure à 1", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(32, "qu'une couleur spécifique est supérieure à 3", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(33, "qu'une couleur spécifique est paire ou impaire", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(34, "la couleur la/l'une des plus petite(s)", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(35, "la couleur la/l'une des plus grande(s)", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(36, "que la somme des nombres est un multiple de 3, 4 ou 5", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(37, "que la somme de deux couleurs spécifiques est égale à 4", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(38, "que la somme de deux couleurs spécifiques est égale à 6", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(39, "le nombre d'une couleur spécifique comparé à 1", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(40, "le nombre d'une couleur spécifique comparé à 3", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(41, "le nombre d'une couleur spécifique comparé à 4", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(42, "quelle couleur est la plus petite ou grande", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(43, "le premier nombre comparé à une autre couleur spécifique", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(44, "le deuxième nombre comparé à une autre couleur spécifique", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(45, "combien de 1 ou de 3 il y a dans le code", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(46, "combien de 3 ou de 4 il y a dans le code", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(47, "combien de 1 ou de 4 il y a dans le code", 
				(Graphics2D g2D) -> {
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(48, "une couleur spécifique comparée à une autre couleur spécifique", 
				(Graphics2D g2D) -> {
				}
			)
		);

	}

	public CriterionThumbnail getCriterionThumbnail(int id) throws NoSuchCriterionException {
		for (CriterionThumbnail criterion: this.criteria)
		{
			if (criterion.getId() == id) return criterion;
		}

		throw new NoSuchCriterionException(id);
	}

}
