package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
    private static int headacheCount = 0;   // initialize to 0
    private static int rashCount = 0;       // initialize to 0
    private static int pupilCount = 0;      // initialize to 0
    
    public static void main(String args[]) throws Exception {
        // first get input
        BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
        String line = reader.readLine();

        //int i=0 
        // int headCount = 0;   // counts headaches // same headacheCount
        while (line != null) {
            //i++;
            System.out.println("symptom from file: " + line);
            if (line.equals("headache")) {
                headacheCount++;
                System.out.println("number of headaches: " + headacheCount);
            } else if (line.equals("rash")) {
                rashCount++;
                System.out.println("number of rashs: " + rashCount);
            } else if (line.contains("pupils")) {
                pupilCount++;
                System.out.println("number of pupils: " + pupilCount);
            }
            line = reader.readLine();   // get another symptom
        }
        reader.close();  // Close the reader outside the loop
        
        // next generate output in result.out
        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n");  
        writer.write("rash: " + rashCount + "\n");
        writer.write("dilated pupils: " + pupilCount + "\n");
        writer.close();
    }
}
