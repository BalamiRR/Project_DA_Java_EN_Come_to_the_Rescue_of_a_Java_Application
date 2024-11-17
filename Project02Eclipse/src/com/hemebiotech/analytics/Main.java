package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 *  This Main class serves as the entry point for the application,
 *  which processes symptom data by reading, counting, sorting, and writing it to a file
 *
 *  Like:
 *  Reading symptoms from an input file.
 *  Counting the occurrences of each symptom.
 *  Sorting the symptoms alphabetically.
 *  Writing the sorted symptoms and their counts to an output file.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Process Starting");
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("results.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);

        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);
        analyticsCounter.writeSymptoms(sortedSymptoms);
        System.out.println("Process Ending");
    }

}
