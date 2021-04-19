package com.hemebiotech.analytics;

import java.util.*;



public class Main {
    public static void main(String[] args) throws Exception{

        AnalyticsCounter callAnalyticsClass = new AnalyticsCounter();

        List<String> readingSymptomsFile = callAnalyticsClass.reading();
        Map<String, Integer> SymptomsClassifiedWithOrrurences = callAnalyticsClass.countAllOccurences(readingSymptomsFile);

        callAnalyticsClass.writing(SymptomsClassifiedWithOrrurences);

    }
}
