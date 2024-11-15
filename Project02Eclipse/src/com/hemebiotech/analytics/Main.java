package com.hemebiotech.analytics;


import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try{
            ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
            ISymptomWriter writer = new WriteSymptomDataToFile("results.out");

            AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

            List<String> symptoms = analyticsCounter.getSymptoms("symptoms.txt");
            Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);
            analyticsCounter.writeSymptoms(symptomCounts);

            Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);
            analyticsCounter.writeSymptoms(sortedSymptoms);


        }catch (Exception e){
            System.err.println("An error occurred while processing the file: " + e);
        }
    }

}
