package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;

public class AnalyticsCounter {

    public static void main(String args[]) {// Remove throws exceptions after creating the try with resoruces
        Map<String, Integer> symptomCounts = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
             FileWriter writer = new FileWriter("result.out")) {

            String line = reader.readLine();

            // Loop to read each line from the file
            while (line != null) {
                line = line.trim().toLowerCase();
                symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
                line = reader.readLine(); // Read next line
            }

            // Writing the results to output file
            for (Map.Entry<String, Integer> entry : symptomCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }

        } catch (IOException e) {
            System.err.println("An error occurred while processing the file: " + e.getMessage());
            e.printStackTrace();
        }

        //Todo : Handle Exception 
        //Todo : Je close manuel resource, auto close able resources java (try, with resources)
    }
}
