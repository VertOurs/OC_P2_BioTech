package com.hemebiotech.analytics;

// es que je peu pas remplacer cela par  java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	/* -------------------------------------------METHODE DE LECTURE-------------------------------------*/

	// void car je n'attends pas un retour précis mais pourquoi utiliser static dans ce contexte?
	static void lecture(){
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
	}

	/*--------------------------------------------METHODE COMPTAGE DES OCCURENCES------------------------*/

	static void compterLesOccurences(){
		// déplacement des variables au plus près du blocs qui les utilise

		//j'ai enlevé private et static, cela a l'air de mieux marché mais je sais pas pourquoi
		int headacheCount = 0;
		int rashCount = 0;
		int pupilCount = 0;

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}
			// a quoi peux bien servir cette ligne ?
			line = reader.readLine();
		}
	}

	/* -----------------------------------------METTRE EN ORDRE ALPHA----------------------------------*/

	static void alphabetique(){



	}

	/*-----------------------------------SORTIR DANS UN FICHIERS RESULT--------------------------------*/

	static void ecriture(){
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

	/*-----------------------------------METHODE MAIN DANS QUI APPEL CHACUNE DES METHODES-------------*/

	public static void main(String args[]) throws Exception {
		lecture();
		compterLesOccurences();
		alphabetique();
		ecriture();

	}
}
