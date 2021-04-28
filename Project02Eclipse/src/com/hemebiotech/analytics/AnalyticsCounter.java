package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;


/**
 * this class reads data from a file then arranges them alphabetically by adding the number of occurrences and finally prints them in another file.
 * @autor Alex
 * @autor raphael
 * @version 2.0
 **/
public class AnalyticsCounter {


    /**
     * retrieve the data from "symptoms.txt" and cross references it as a list.
     * @return a list of character strings that represents the list of Symptoms.
     */
    public List<String> reading() {
	    ISymptomReader read = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> listOfSymptoms = read.GetSymptoms();

        return listOfSymptoms;
    }

    /**
     * counts occurrences of a single symptom.
     * @param countOccu the string of characters whose occurrence we want to count.
     * @param listOfSymptoms a list of symptoms.
     * @return the number of occurrences of the symptom in question.
     */
    public int countOccurences(String countOccu,List<String> listOfSymptoms) {
        int nbOccurence = 0;

        for (String count : listOfSymptoms) {
            if (count.equals(countOccu)) {
                nbOccurence++;
            }
        }
        return nbOccurence;
    }

    /**
     * this method allows to alphabetically organize the contents of a list while allowing to count all the occurrences of the symptoms of the list.
     * @param listOfSymptoms a list of symptoms.
     * @return Map sorts in alphabetical order and displays the occurrences of each symptom
     */
    public Map<String, Integer> countAllOccurences(List<String> listOfSymptoms) {
        Map<String, Integer> map = new TreeMap<>();

        for (String symptom : listOfSymptoms) {
            if (map.containsKey(symptom)) {
                int nbOccurence = map.get(symptom);
                nbOccurence = nbOccurence + 1;
                map.replace(symptom, nbOccurence);
            } else {
                map.put(symptom, 1);
            }
        }
        return map;
    }

    /**
     * this method allows you to alphabetically organize the contents of a list.
     * @param listOfSymptoms a list of symptoms.
     * @return a list arranged in alphabetical order.
     */
    public List<String> alphaOrder(List<String> listOfSymptoms) {
        Collections.sort(listOfSymptoms);

        return listOfSymptoms;
    }

    /**
     * this method allows to write in a result.out file the contents of the Map organized in treeMap
     * @param mapOfSymptoms a Map object containing the symptoms and their occurrences.
     * @throws IOException an exception related to FileWriter can be thrown.
     */
    public void writing(Map<String, Integer> mapOfSymptoms) throws IOException {
        FileWriter writer = new FileWriter("result.out");
        Set<String> key = mapOfSymptoms.keySet();

        for(String i : key){
            int symptoms = mapOfSymptoms.get(i);
            writer.write(i+" = "+symptoms+"\n");
        }
        writer.close();
    }
}

