package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;
/**
 * this class reads data from a file then arranges them alphabetically by adding the number of occurrences and finally prints them in another file.
 *Currently two methods are not used / it is used to decompose the count of an occurrence and the arrangement in alphabetical order.
 *
 * **/


public class AnalyticsCounter {
/**
 * retrieve the data from "symptoms.txt" and cross references it as a list.
 **/
    public List<String> reading() {
	    ISymptomReader read = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> listOfSymptoms = read.GetSymptoms();

        return listOfSymptoms;
    }

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
 * @return Map sorts in alphabetical order and displays the occurrences of each symptom
 **/
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

    public List<String> alphaOrder(List<String> listOfSymptoms) {
        Collections.sort(listOfSymptoms);

        return listOfSymptoms;
    }
/**
 * @return a file including all the symptoms of the Map and the number of occurrences associated with each of them.
 **/
    static void writing(Map<String, Integer> mapOfSymptoms) throws IOException {
        FileWriter writer = new FileWriter("result.out");
        Set<String> key = mapOfSymptoms.keySet();

        for(String i : key){
            int symptoms = mapOfSymptoms.get(i);
            writer.write(i+" = "+symptoms+"\n");
        }
        writer.close();
    }
}
