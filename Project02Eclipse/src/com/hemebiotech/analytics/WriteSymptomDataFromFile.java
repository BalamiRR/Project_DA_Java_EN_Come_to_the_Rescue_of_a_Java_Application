package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomDataFromFile {
    public void writeSymptoms(Map<String, Integer> symptoms){
            // next generate output in result.out
            FileWriter writer = new FileWriter("result.out");
            writer.write("headache: " + headacheCount + "\n");  
            writer.write("rash: " + rashCount + "\n");
            writer.write("dilated pupils: " + pupilCount + "\n");
            writer.close();
    }

}
