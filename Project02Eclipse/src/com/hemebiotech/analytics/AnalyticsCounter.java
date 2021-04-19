package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;


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

    public Map<String, Integer> countAllOccurences(List<String> listOfSymptoms) {
        Map<String, Integer> map = new TreeMap<>();

        for(int i = 0; i< listOfSymptoms.size(); i++){
            String symptom = listOfSymptoms.get(i);

            if(map.containsKey(symptom)){
                int nbOccurence = map.get(symptom);
                nbOccurence = nbOccurence+1;
                map.replace(symptom, nbOccurence);
            }
            else{
                map.put(symptom,1);
            }
        }
        return map;
    }

    public List<String> alphaOrder(List<String> listOfSymptoms) {
        Collections.sort(listOfSymptoms);

        return listOfSymptoms;
    }

    static void writing(Map<String, Integer> mapOfSymptoms) throws IOException {
        FileWriter writer = new FileWriter("result.out");
        Set<String> key = mapOfSymptoms.keySet();

        for(String i : key){
            int symptoms = mapOfSymptoms.get(i);
            writer.write(i+" = "+String.valueOf(symptoms)+"\n");
        }
        writer.close();
    }
}
