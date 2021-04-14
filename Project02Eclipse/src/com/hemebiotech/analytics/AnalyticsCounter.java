package com.hemebiotech.analytics;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class AnalyticsCounter {

    public List<String> reading() {
	    ISymptomReader read = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> listOfSymptoms = read.GetSymptoms();

        return listOfSymptoms;
    }

    public int countOccurences(String countOccu,List<String> listOfSymptoms) {
        int nbOccurence = 0;

        for(int i = 0; i<listOfSymptoms.size(); i++){
            String count = listOfSymptoms.get(i);
            if (count == countOccu ){
                nbOccurence++;
            }
        }
        return nbOccurence;
    }

    public void countAllOccurences() {
        return;
    }

    public List<String> alphaOrder(List<String> listOfSymptoms) {
        Collections.sort(listOfSymptoms);

        return listOfSymptoms;
    }

    static void writing(List<String>listOfSymptoms) throws IOException {
        File file = new File("result.out");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        for(String i : listOfSymptoms){
            writer.write(i);
        }
        writer.close();
    }


}
// ligne 43 avec utilisation ligne 48 : je ne comprends pas ce paramètre (countOccu) d'ou sors t il?