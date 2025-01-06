package com.turing_machine.database;

import com.turing_machine.base_objects.CodeIndex;
import com.turing_machine.exceptions.NoSuchCaseException;
import com.turing_machine.images.ImageDescriptable;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class CasesThumbnailsDatabase {

	private final ArrayList<CriterionCaseThumbnail> cases;

	protected CasesThumbnailsDatabase() {
		this.cases = new ArrayList<>();

		/*

			Description des différents cas possibles

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
			new CriterionCaseThumbnail(1, "bleu est égal à 1",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(3, "bleu est égal à 3",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(4, "bleu est égal à 4",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw4Value(g2D, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(5, "bleu est égal à 5",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw5Value(g2D, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(6, "jaune est égal à 1",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(8, "jaune est égal à 3",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(9, "jaune est égal à 4",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw4Value(g2D, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(10, "jaune est égal à 5",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw5Value(g2D, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(11, "violet est égal à 1",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(13, "violet est égal à 3",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(14, "violet est égal à 4",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw4Value(g2D, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(15, "violet est égal à 5",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					ImageDescriptable.draw5Value(g2D, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(16, "bleu est supérieur à 1",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(18, "bleu est supérieur à 3",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(19, "jaune est supérieur à 1",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(21, "jaune est supérieur à 3",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(22, "violet est supérieur à 1",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(24, "violet est supérieur à 3",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(25, "bleu est inférieur à 3",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawLowerThan(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(26, "bleu est inférieur à 4",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawLowerThan(g2D, 75, 30, 20);
					ImageDescriptable.draw4Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(28, "jaune est inférieur à 3",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawLowerThan(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(29, "jaune est inférieur à 4",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawLowerThan(g2D, 75, 30, 20);
					ImageDescriptable.draw4Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(31, "violet est inférieur à 3",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawLowerThan(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(32, "violet est inférieur à 4",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawLowerThan(g2D, 75, 30, 20);
					ImageDescriptable.draw4Value(g2D, 112, 30, 20);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(34, "bleu est pair",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 45, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawText(g2D, "est pair", 60, 30, 12);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(35, "jaune est pair",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 45, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawText(g2D, "est pair", 60, 30, 12);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(36, "violet est pair",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 45, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawText(g2D, "est pair", 60, 30, 12);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(37, "bleu est impair",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 42, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawText(g2D, "est impair", 58, 30, 12);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(38, "jaune est impair",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 42, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawText(g2D, "est impair", 58, 30, 12);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(39, "violet est impair",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 42, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawText(g2D, "est impair", 58, 30, 12);

				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(40, "aucun 1",
				(Graphics g2D) -> {
					ImageDescriptable.draw2Value(g2D, 55, 30, 20);
					ImageDescriptable.draw5Value(g2D, 75, 30, 20);
					ImageDescriptable.draw2Value(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(41, "un 1",
				(Graphics g2D) -> {
					ImageDescriptable.draw3Value(g2D, 55, 30, 20);
					ImageDescriptable.draw3Value(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 95, 30, 20);

					ImageDescriptable.drawValueSubline(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(42, "deux 1",
				(Graphics g2D) -> {
					ImageDescriptable.draw1Value(g2D, 55, 30, 20);
					ImageDescriptable.draw5Value(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 95, 30, 20);

					ImageDescriptable.drawValueSubline(g2D, 55, 30, 20);
					ImageDescriptable.drawValueSubline(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(46, "aucun 3",
				(Graphics g2D) -> {
					ImageDescriptable.draw5Value(g2D, 55, 30, 20);
					ImageDescriptable.draw1Value(g2D, 75, 30, 20);
					ImageDescriptable.draw4Value(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(47, "un 3",
				(Graphics g2D) -> {
					ImageDescriptable.draw3Value(g2D, 55, 30, 20);
					ImageDescriptable.draw5Value(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 95, 30, 20);

					ImageDescriptable.drawValueSubline(g2D, 55, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(48, "deux 3",
				(Graphics g2D) -> {
					ImageDescriptable.draw5Value(g2D, 55, 30, 20);
					ImageDescriptable.draw3Value(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 95, 30, 20);

					ImageDescriptable.drawValueSubline(g2D, 75, 30, 20);
					ImageDescriptable.drawValueSubline(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(49, "aucun 4",
				(Graphics g2D) -> {
					ImageDescriptable.draw5Value(g2D, 55, 30, 20);
					ImageDescriptable.draw1Value(g2D, 75, 30, 20);
					ImageDescriptable.draw2Value(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(50, "un 4",
				(Graphics g2D) -> {
					ImageDescriptable.draw4Value(g2D, 55, 30, 20);
					ImageDescriptable.draw5Value(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 95, 30, 20);

					ImageDescriptable.drawValueSubline(g2D, 55, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(51, "deux 4",
				(Graphics g2D) -> {
					ImageDescriptable.draw5Value(g2D, 55, 30, 20);
					ImageDescriptable.draw4Value(g2D, 75, 30, 20);
					ImageDescriptable.draw4Value(g2D, 95, 30, 20);

					ImageDescriptable.drawValueSubline(g2D, 75, 30, 20);
					ImageDescriptable.drawValueSubline(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(55, "la somme des trois chiffres est paire",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 20, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 35, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 50, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 65, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 80, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 100, 30, 15);
					ImageDescriptable.drawText(g2D, "pair", 110, 30, 10);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(56, "la somme des trois chiffres est impaire",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 20, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 35, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 50, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 65, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 80, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 100, 30, 15);
					ImageDescriptable.drawText(g2D, "impair", 110, 30, 10);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(57, "la somme des trois chiffres est un multiple de 3",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 20, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 35, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 50, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 65, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 80, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 100, 30, 15);
					ImageDescriptable.draw3Value(g2D, 115, 30, 15);
					ImageDescriptable.drawMult(g2D, 130, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(58, "la somme des trois chiffres est un multiple de 4",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 20, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 35, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 50, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 65, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 80, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 100, 30, 15);
					ImageDescriptable.draw4Value(g2D, 115, 30, 15);
					ImageDescriptable.drawMult(g2D, 130, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(59, "la somme des trois chiffres est un multiple de 5",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 20, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 35, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 50, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 65, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 80, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 100, 30, 15);
					ImageDescriptable.draw5Value(g2D, 115, 30, 15);
					ImageDescriptable.drawMult(g2D, 130, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(60, "la somme des trois chiffres est 6",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 20, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 35, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 50, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 65, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 80, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 100, 30, 15);
					ImageDescriptable.draw6Value(g2D, 115, 30, 15);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(67, "la somme des trois chiffres est supérieure à 6",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 20, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 35, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 50, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 65, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 80, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 100, 30, 15);
					ImageDescriptable.draw6Value(g2D, 115, 30, 15);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(74, "la somme des trois chiffres est inférieure à 6",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 20, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 35, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 50, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawPlus(g2D, 65, 30, 15);
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 80, 30, 15);
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawLowerThan(g2D, 100, 30, 15);
					ImageDescriptable.draw6Value(g2D, 115, 30, 15);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(81, "aucun jumeau",
				(Graphics g2D) -> {
					ImageDescriptable.draw1Value(g2D, 15, 30, 20);
					ImageDescriptable.draw3Value(g2D, 35, 30, 20);
					ImageDescriptable.draw4Value(g2D, 55, 30, 20);

					ImageDescriptable.drawSeparation(g2D, 75, 30, 20);

					ImageDescriptable.draw2Value(g2D, 95, 30, 20);
					ImageDescriptable.draw2Value(g2D, 115, 30, 20);
					ImageDescriptable.draw2Value(g2D, 135, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(82, "des jumeaux",
				(Graphics g2D) -> {
					ImageDescriptable.draw1Value(g2D, 55, 30, 20);
					ImageDescriptable.draw3Value(g2D, 75, 30, 20);
					ImageDescriptable.draw1Value(g2D, 95, 30, 20);

					ImageDescriptable.drawValueSubline(g2D, 55, 30, 20);
					ImageDescriptable.drawValueSubline(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(83, "aucun nombre dans l'ordre croissant",
				(Graphics g2D) -> {
					ImageDescriptable.draw0Value(g2D, 60, 30, 30);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawTopRightArrow(g2D, 90, 30, 30);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(84, "deux nombres dans l'ordre croissant",
				(Graphics g2D) -> {
					ImageDescriptable.draw2Value(g2D, 60, 30, 30);
					g2D.setColor(new Color(0xF36322));
					ImageDescriptable.drawTopRightArrow(g2D, 90, 30, 30);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(85, "pas de pairs, 3 impairs",
				(Graphics g2D) -> {
					ImageDescriptable.draw5Value(g2D, 55, 30, 20);
					ImageDescriptable.draw1Value(g2D, 75, 30, 20);
					ImageDescriptable.draw3Value(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(86, "un pair, deux impairs",
				(Graphics g2D) -> {
					ImageDescriptable.draw5Value(g2D, 55, 30, 20);
					ImageDescriptable.draw1Value(g2D, 75, 30, 20);
					ImageDescriptable.draw2Value(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(87, "deux pairs, un impair",
				(Graphics g2D) -> {
					ImageDescriptable.draw2Value(g2D, 55, 30, 20);
					ImageDescriptable.draw3Value(g2D, 75, 30, 20);
					ImageDescriptable.draw2Value(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(88, "trois pairs, aucun impair",
				(Graphics g2D) -> {
					ImageDescriptable.draw2Value(g2D, 55, 30, 20);
					ImageDescriptable.draw2Value(g2D, 75, 30, 20);
					ImageDescriptable.draw2Value(g2D, 95, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(89, "bleu égal jaune",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);

					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(90, "bleu égal violet",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(91, "jaune égal violet",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawEquals(g2D, 75, 30, 20);
					
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(92, "bleu est supérieur à jaune",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);

					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(93, "bleu est supérieur à violet",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);

					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(94, "jaune est supérieur à bleu",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);

					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(95, "jaune est supérieur à violet",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);

					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(96, "violet est supérieur à bleu",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);

					ImageDescriptable.drawIndex(g2D, CodeIndex.FIRST_BLUE_TRIANGLE, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(97, "violet est supérieur à jaune",
				(Graphics g2D) -> {
					ImageDescriptable.drawIndex(g2D, CodeIndex.THIRD_PURPLE_CIRCLE, 38, 30, 20);
					
					g2D.setColor(Color.BLACK);
					ImageDescriptable.drawGreaterThan(g2D, 75, 30, 20);

					ImageDescriptable.drawIndex(g2D, CodeIndex.SECOND_YELLOW_SQUARE, 112, 30, 20);
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(98, "bleu plus jaune vaut 4",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(100, "bleu plus jaune vaut 6",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(103, "bleu plus violet vaut 4",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(105, "bleu plus violet vaut 6",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(108, "jaune plus violet vaut 4",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(110, "jaune plus violet vaut 6",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(113, "bleu est le plus grand",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(114, "jaune est le plus grand",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(115, "violet est le plus grand",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(116, "bleu est le plus petit",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(117, "jaune est le plus petit",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(118, "violet est le plus petit",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(119, "trois fois un chiffre",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(120, "deux fois un chiffre",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(121, "aucune répétition",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(122, "aucune séquence croissante ou décroissante",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(123, "deux nombres croissants ou décroissants",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(124, "trois nombres croissants ou décroissants",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(125, "bleu est le/l'un des plus grand(s)",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(126, "jaune est le/l'une des plus grand(s)",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(127, "violet est le/l'une des plus grand(s)",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(128, "bleu est le/l'un des plus petit(s)",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(129, "jaune est le/l'un des plus petit(s)",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(130, "violet est le/l'un des plus petit(s)",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(131, "il y a plus de nombres pairs",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(132, "il y a plus de nombres impairs",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(133, "les nombres sont dans l'ordre croissant",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(134, "les nombres sont dans l'ordre décroissant",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(135, "aucun ordre particulier",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(136, "la somme de bleu et jaune est supérieure à 6",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(137, "la somme de bleu et jaune est inférieure à 6",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(138, "jaune est supérieur à 4",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(139, "bleu est inférieur à jaune",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(140, "bleu est inférieur à violet",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(141, "jaune est inférieur à violet",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(142, "bleu est supérieur à 4",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(143, "violet est supérieur à 4",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(144, "jaune est inférieur à bleu",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(145, "jaune est égal à bleu",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(400, "trois 1",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(401, "trois 3",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(402, "trois 4",
				(Graphics g2D) -> {
				}
			)
		);

		this.cases.add(
			new CriterionCaseThumbnail(403, "trois nombres dans l'ordre croissant",
				(Graphics g2D) -> {
				}
			)
		);
	}

	public CriterionCaseThumbnail getCase(int case_id) throws NoSuchCaseException {
		for (CriterionCaseThumbnail criterion: this.cases)
		{
			if (criterion.getId() == case_id) return criterion;
		}

		throw new NoSuchCaseException(case_id);
	}

}
