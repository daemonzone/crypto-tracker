package it.academy.crypto.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public List<String> loadFile(String filePath){
        List<String> results = new ArrayList<String>();

        try (BufferedReader r = new BufferedReader(new FileReader(filePath))) {
            String line;
            do {
                line = r.readLine();
                if (line != null) { results.add(line); }
            } while (line != null);

        } catch (Exception e) {
            System.out.println("ERROR - Error loading file: '" + filePath + "' ("  + e.getMessage() + ")");
        }

        return results;
    }

}
