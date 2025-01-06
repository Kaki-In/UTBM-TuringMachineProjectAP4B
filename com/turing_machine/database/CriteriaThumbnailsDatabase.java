package com.turing_machine.database;

import com.turing_machine.base_objects.CodeIndex;
import com.turing_machine.exceptions.NoSuchCriterionException;
import com.turing_machine.images.ImageDescriptable;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class CriteriaThumbnailsDatabase {

	private final ArrayList<CriterionThumbnail> criteria;

	protected CriteriaThumbnailsDatabase() {
		this.criteria = new ArrayList<>();

		this.criteria.add(
			new CriterionThumbnail(1, "le premier nombre comparé à 1", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 50, 40, 30);

					ImageDescriptable.draw1Value(g2D, 75, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(2, "le premier nombre comparé à 3", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 50, 40, 30);

					ImageDescriptable.draw3Value(g2D, 75, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(3, "le deuxième nombre comparé à 3", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 50, 40, 30);

					ImageDescriptable.draw3Value(g2D, 75, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(4, "le deuxième nombre comparé à 4", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 50, 40, 30);

					ImageDescriptable.draw4Value(g2D, 75, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(5, "si le premier nombre est pair ou impair", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawText(g2D, "pair", 60, 30, 10);
					ImageDescriptable.drawText(g2D, "impair", 60, 50, 10);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(6, "si le deuxième nombre est pair ou impair", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 25, 40, 30);

					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawText(g2D, "pair", 60, 30, 10);
					ImageDescriptable.drawText(g2D, "impair", 60, 50, 10);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(7, "si le troisième nombre est pair ou impair", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawText(g2D, "pair", 60, 30, 10);
					ImageDescriptable.drawText(g2D, "impair", 60, 50, 10);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(8, "le nombre de 1 dans le code", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));

					ImageDescriptable.drawText(g2D, "?", 20, 35, 30);
					ImageDescriptable.drawMult(g2D, 50, 40, 30);
					ImageDescriptable.draw1Value(g2D, 80, 40, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(9, "le nombre de 3 dans le code", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));

					ImageDescriptable.drawText(g2D, "?", 20, 35, 30);
					ImageDescriptable.drawMult(g2D, 50, 40, 30);
					ImageDescriptable.draw3Value(g2D, 80, 40, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(10, "le nombre de 4 dans le code", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));

					ImageDescriptable.drawText(g2D, "?", 20, 35, 30);
					ImageDescriptable.drawMult(g2D, 50, 40, 30);
					ImageDescriptable.draw4Value(g2D, 80, 40, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(11, "le premier nombre comparé au deuxième", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 50, 40, 30);

					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 75, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(12, "le premier nombre comparé au troisième", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 50, 40, 30);

					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 75, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(13, "le deuxième nombre comparé au troisième", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 50, 40, 30);

					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 75, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(14, "quel nombre est strictement plus petit que les autres", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 35, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 65, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 50, 60, 15);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(15, "quel nombre est strictement plus grand que les autres", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 35, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 65, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 50, 60, 15);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(16, "le nombre de valeurs paires comparés au nombre de valeurs impaires", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));

					ImageDescriptable.drawText(g2D, "paire", 10, 40, 10);
					ImageDescriptable.drawBalance(g2D, 50, 40, 40);
					ImageDescriptable.drawText(g2D, "impaire", 55, 40, 10);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(17, "le nombre de valeurs paires dans le code", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawText(g2D, "?", 10, 35, 35);
					ImageDescriptable.drawMult(g2D, 40, 40, 35);
					ImageDescriptable.drawText(g2D, "paire", 55, 40, 10);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(18, "si la somme des nombres est paire ou impaire", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 10, 20, 20);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawPlus(g2D, 30, 20, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 50, 20, 20);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawPlus(g2D, 70, 20, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 90, 20, 20);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawText(g2D, "pair/impair", 20, 60, 10);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(19, "la somme du premier et deuxième nombres comparée à 6", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 10, 40, 20);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawPlus(g2D, 30, 40, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 50, 40, 20);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 70, 40, 20);
					ImageDescriptable.draw6Value(g2D, 80, 40, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(20, "si un nombre se répète dans le code", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawText(g2D, "?", 20, 35, 35);
					ImageDescriptable.drawMult(g2D, 50, 40, 35);
					ImageDescriptable.drawText(g2D, "X", 80, 35, 35);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(21, "s'il y a des jumeaux (non triplés)", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawText(g2D, "XXY", 20, 35, 35);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(22, "si les 3 nombres sont dans l'ordre croissant, décroissant ou non ordonnés", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawPodium(g2D, 1, 2, 3, 50, 20, 15);
					ImageDescriptable.drawPodium(g2D, 3, 2, 1, 50, 40, 15);
					ImageDescriptable.drawPodium(g2D, 3, 1, 2, 50, 60, 15);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(23, "la somme de tous les nombres comparée à 6", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 10, 40, 15);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawPlus(g2D, 25, 40, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 40, 40, 15);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawPlus(g2D, 55, 40, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 70, 40, 15);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 85, 40, 15);
					ImageDescriptable.draw6Value(g2D, 90, 40, 15);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(24, "s'il y a une séquence de nombres croissants", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawTopRightArrow(g2D, 50, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(25, "s'il y a une séquence de nombres croissants ou décroissants", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawTopDownArrows(g2D, 50, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(26, "qu'une couleur spécifique est plus petite que 3", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 35, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 30, 60, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawLowerThan(g2D, 65, 40, 30);
					ImageDescriptable.draw3Value(g2D, 85, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(27, "qu'une couleur spécifique est plus petite que 4", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 35, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 30, 60, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawLowerThan(g2D, 65, 40, 30);
					ImageDescriptable.draw4Value(g2D, 85, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(28, "qu'une couleur spécifique est égale à 1", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 35, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 30, 60, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawEquals(g2D, 65, 40, 30);
					ImageDescriptable.draw1Value(g2D, 85, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(29, "qu'une couleur spécifique est égale à 3", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 35, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 30, 60, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawEquals(g2D, 65, 40, 30);
					ImageDescriptable.draw3Value(g2D, 85, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(30, "qu'une couleur spécifique est égale à 4", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 35, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 30, 60, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawEquals(g2D, 65, 40, 30);
					ImageDescriptable.draw4Value(g2D, 85, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(31, "qu'une couleur spécifique est supérieure à 1", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 35, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 30, 60, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawGreaterThan(g2D, 65, 40, 30);
					ImageDescriptable.draw1Value(g2D, 85, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(32, "qu'une couleur spécifique est supérieure à 3", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 35, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 30, 60, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawGreaterThan(g2D, 65, 40, 30);
					ImageDescriptable.draw3Value(g2D, 85, 40, 30);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(33, "si une couleur spécifique est paire ou impaire", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 35, 30, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 65, 30, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 50, 50, 10);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawText(g2D, "pair/impair", 20, 60, 10);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(34, "la couleur la/l'une des plus petite(s)", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 35, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 65, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 50, 60, 15);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(35, "la couleur la/l'une des plus grande(s)", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 35, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 65, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 50, 60, 15);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(36, "que la somme des nombres est un multiple de 3, 4 ou 5", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 10, 40, 15);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawPlus(g2D, 25, 40, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 40, 40, 15);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawPlus(g2D, 55, 40, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 70, 40, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 85, 40, 15);
					ImageDescriptable.draw3Value(g2D, 90, 20, 10);
					ImageDescriptable.draw4Value(g2D, 90, 40, 10);
					ImageDescriptable.draw5Value(g2D, 90, 60, 10);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(37, "que la somme de deux couleurs spécifiques est égale à 4", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawText(g2D, "?", 10, 35, 30);
					ImageDescriptable.drawPlus(g2D, 30, 40, 20);
					ImageDescriptable.drawText(g2D, "?", 40, 35, 30);
					ImageDescriptable.drawEquals(g2D, 70, 40, 20);
					ImageDescriptable.draw4Value(g2D, 90, 40, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(38, "que la somme de deux couleurs spécifiques est égale à 6", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawText(g2D, "?", 10, 35, 30);
					ImageDescriptable.drawPlus(g2D, 30, 40, 20);
					ImageDescriptable.drawText(g2D, "?", 40, 35, 30);
					ImageDescriptable.drawEquals(g2D, 70, 40, 20);
					ImageDescriptable.draw6Value(g2D, 90, 40, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(39, "le nombre d'une couleur spécifique comparé à 1", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 35, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 30, 60, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 72, 40, 35);
					ImageDescriptable.draw1Value(g2D, 80, 40, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(40, "le nombre d'une couleur spécifique comparé à 3", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 35, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 30, 60, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 72, 40, 35);
					ImageDescriptable.draw3Value(g2D, 80, 40, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(41, "le nombre d'une couleur spécifique comparé à 4", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 35, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 30, 60, 15);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 72, 40, 35);
					ImageDescriptable.draw4Value(g2D, 80, 40, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(42, "quelle couleur est la plus petite ou grande", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 35, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 65, 35, 30);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 50, 60, 15);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(43, "le premier nombre comparé à une autre couleur spécifique", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 50, 40, 30);

					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 75, 30, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 75, 50, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(44, "le deuxième nombre comparé à une autre couleur spécifique", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 25, 40, 30);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 50, 40, 30);

					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 75, 30, 20);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 75, 50, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(45, "combien de 1 ou de 3 il y a dans le code", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));

					ImageDescriptable.drawText(g2D, "?", 20, 35, 30);
					ImageDescriptable.drawMult(g2D, 50, 40, 30);
					ImageDescriptable.draw1Value(g2D, 80, 25, 20);
					ImageDescriptable.draw3Value(g2D, 80, 55, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(46, "combien de 3 ou de 4 il y a dans le code", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));

					ImageDescriptable.drawText(g2D, "?", 20, 35, 30);
					ImageDescriptable.drawMult(g2D, 50, 40, 30);
					ImageDescriptable.draw3Value(g2D, 80, 25, 20);
					ImageDescriptable.draw4Value(g2D, 80, 55, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(47, "combien de 1 ou de 4 il y a dans le code", 
				(Graphics g2D) -> {
					g2D.setColor(new Color(0xF36322));

					ImageDescriptable.drawText(g2D, "?", 20, 35, 30);
					ImageDescriptable.drawMult(g2D, 50, 40, 30);
					ImageDescriptable.draw1Value(g2D, 80, 25, 20);
					ImageDescriptable.draw4Value(g2D, 80, 55, 20);
				}
			)
		);

		this.criteria.add(
			new CriterionThumbnail(48, "une couleur spécifique comparée à une autre couleur spécifique", 
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 15, 35, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 35, 35, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 25, 50, 10);

					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawBalance(g2D, 55, 35, 30);

					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 65, 35, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 85, 35, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 75, 50, 10);
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
