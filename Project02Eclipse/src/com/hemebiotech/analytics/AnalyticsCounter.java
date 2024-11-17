package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class handles reading, counting, sorting, and writing symptom data.
 * It works with implementations of the ISymptomReader and ISymptomWriter interfaces to get
 * the symptom data from a source and save the processed results to a destination.
 */
public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();
        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
        return symptomCounts;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}
