package com.hemebiotech.analytics;

import java.util.*;
/**
 *  This method is made up of three calls to the methods contained in the AnalyticsCounter class.
 *  readingSymptomsFile which is used to retrieve the data from the ze file which arranges the symptoms in alphabetical order and provides the number of occurrences.
 *  and writing which allows you to put this data in a separate file.
 **/


public class Main {
    public static void main(String[] args) throws Exception{

        AnalyticsCounter callAnalyticsClass = new AnalyticsCounter();

        List<String> readingSymptomsFile = callAnalyticsClass.reading();
        Map<String, Integer> SymptomsClassifiedWithOrrurences = callAnalyticsClass.countAllOccurences(readingSymptomsFile);

        callAnalyticsClass.writing(SymptomsClassifiedWithOrrurences);

    }
}
