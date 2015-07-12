package com.coding.duplicates.service;

import com.coding.duplicates.util.FileParser;

import java.util.List;

public class FirstNameValidator {

    public static List<List<String>> parsedRecords = FileParser.getSplitListOfRecords("Firstnames.txt");

    public static boolean validateForSameNames(String nameOne, String nameTwo) {
        if (nameOne.equals(nameTwo)) {
            return true;
        }
        for (List<String> listOfSameFirstNames : parsedRecords) {
            if (listOfSameFirstNames.contains(nameOne) && listOfSameFirstNames.contains(nameTwo)) {
                return true;
            }
        }
        return false;
    }
}
