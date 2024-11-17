package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 *  The WriteSymptomDataToFile class is an implementation of the ISymptomWriter interface
 *  for writing symptoms data to a specified file.
 *
 *  This class takes a filename as input during instantiation and writes a map of symptoms
 *
*/
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