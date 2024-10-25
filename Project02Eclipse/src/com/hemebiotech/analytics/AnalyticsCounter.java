package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {

    public static void main(String args[]) throws Exception {
        Map<String, Integer> symptomCounts = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();

        // Loop through each symptom in the file
        while (line != null) {
            line = line.trim().toLowerCase(); // Trim spaces and convert to lowercase for consistency
            symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
            line = reader.readLine(); // Read next line
        }
        reader.close(); // Close the reader

        // Write the results to the output file
        FileWriter writer = new FileWriter("result.out");
        for (Map.Entry<String, Integer> entry : symptomCounts.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        writer.close();
    }
}
