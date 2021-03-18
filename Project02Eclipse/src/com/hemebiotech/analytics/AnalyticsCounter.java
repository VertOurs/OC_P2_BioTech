package com.hemebiotech.analytics;

// es que je peu pas remplacer cela par  java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	/* -------------------------------------------METHODE DE LECTURE-------------------------------------*/

	// void car je n'attends pas un retour précis mais pourquoi utiliser static dans ce contexte?
	// dois je fermer cette methode de lecture? a quoi sert le deuxieme ligne.
	static void lecture(){
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
	}

	/*--------------------------------------------METHODE COMPTAGE DES OCCURENCES------------------------*/

	static void compterLesOccurences(){
		// déplacement des variables au plus près du blocs qui les utilise

		//j'ai enlevé private et static, cela a l'air de mieux marché mais je sais pas pourquoi
		//le compilateur me renvoi des erreur cannot find symbol varaible pk?
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
      /* j'ai trouver des exemples de type :
      Java Program to Sort Names in an Alphabetical Order

import java.io.*;

class GFG {
    public static void main(String[] args)
    {
        // storing input in variable
        int n = 4;

        // create string array called names
        String names[]
            = { "Rahul", "Ajay", "Gourav", "Riya" };
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // to compare one string with other strings
                if (names[i].compareTo(names[j]) > 0) {
                    // swapping
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }

        // print output array
        System.out.println(
            "The names in alphabetical order are: ");
        for (int i = 0; i < n; i++) {
            System.out.println(names[i]);
        }
    }
}


	}

     mais pour le coup je comprend pas comment cela marche  */

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
