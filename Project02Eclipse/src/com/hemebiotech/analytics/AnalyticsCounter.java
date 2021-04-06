package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {
	/* -------------------------------------------METHODE DE LECTURE-------------------------------------*/

	public List<String> lecture() throws IOException {
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));

		List<String> listlecture = new ArrayList();
		String line = reader.readLine();


		while (line != null){
			listlecture.add(line);
			line = reader.readLine();
		}

		return	listlecture;
	}
	/*--------------------------------------------METHODE COMPTAGE DES OCCURENCES------------------------*/

	public int compterLesOccurences(String compteOccurences, List<String> listlecture) {

        int nbOccurence = 0;

        for (int i = 0; i < listlecture.size(); i++) {
            String a = listlecture.get(i);

            if (a == compteOccurences) {
                nbOccurence++;
            }
        }
    }

	/* -----------------------------------------METTRE EN ORDRE ALPHA----------------------------------*/

	//public void alphabetique(){}




	/*-----------------------------------SORTIR DANS UN FICHIERS RESULT--------------------------------*/

	public void ecriture(List<String> listlecture) throws IOException{

	    File file = new File("result.out");

	    try(BufferedWriter ecrire = new BufferedWriter(new FileWriter(file))){
            while (listlecture != null) {
                ecrire.write(String.valueOf(listlecture));
            }
                ecrire.close();

	    } catch(IOException e){
	        e.printStackTrace();

        }





	}




}
