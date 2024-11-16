package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private final String filename;

    public WriteSymptomDataToFile(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            System.out.println("Symptoms successfully written");
        } catch (IOException e) {
            throw new UnsupportedOperationException("Can not write the symptoms to the file " + e);
        }
    }
}