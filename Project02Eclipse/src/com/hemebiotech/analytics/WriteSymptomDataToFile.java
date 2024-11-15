package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filename;

    public WriteSymptomDataToFile(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
    }
}