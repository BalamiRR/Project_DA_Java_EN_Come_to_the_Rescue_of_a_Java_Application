package com.hemebiotech.analytics;

import java.util.Map;

/**
 *  The ISymptomWriter interface serves as a blueprint for writing symptom data to a
 *  specified output destination.
 * */

public interface ISymptomWriter{
    void writeSymptoms(Map<String, Integer> symptoms);
}

