package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> symptoms = new ArrayList<>();

		if(filepath == null){
			throw new IllegalArgumentException("Please a provide a filepath " + filepath);
		}

		try (BufferedReader reader = new BufferedReader (new FileReader(filepath));){
			String line = reader.readLine();

			while (line != null) {
				line = line.trim().toLowerCase();
				symptoms.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Can not open a file "  + e);
		}
		
		return symptoms;
	}

}
