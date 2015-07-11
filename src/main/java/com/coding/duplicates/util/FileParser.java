package com.coding.duplicates.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class FileParser {

    public static List<String> parseFileByLine(String fileName) {
        try {
            List<String> content = new ArrayList<String>();
            File file = new File(fileName);
            Scanner fScan = new Scanner(file);
            while (fScan.hasNextLine()) {
                content.add(fScan.nextLine());
            }
            return content;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<List<String>> getSplitListOfRecords(String fileName) {
        List<String> contentLines = parseFileByLine(fileName);
        List<List<String>> splitRecords = new ArrayList<List<String>>();
        for (String line : contentLines) {
            splitRecords.add(asList(line.split(", | - ")));
        }
        return splitRecords;
    }
}
