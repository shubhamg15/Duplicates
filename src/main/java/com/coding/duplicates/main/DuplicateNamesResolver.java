package com.coding.duplicates.main;

import com.coding.duplicates.service.DuplicateNamesResolverService;
import com.coding.duplicates.util.FileParser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DuplicateNamesResolver {

    public static List<String> inputNames = FileParser.parseFileByLine("names.input");

    public static void main(String[] args) {

        System.out.println("\nProcessing names.input to group the duplicate names together...\n");

        List<List<String>> outputNamesList = new DuplicateNamesResolverService().groupDuplicateNameRecords(inputNames);

        // Sorting the output list in decreasing order of the sub list size ie duplicate records list
        Collections.sort(outputNamesList, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> a, List<String> b) {
                return new Integer(b.size()).compareTo(a.size());
            }
        });

        // Display the list
        int size = 0;
        for (List<String> duplicates : outputNamesList) {
            System.out.println(duplicates);
            size = size + duplicates.size();
        }
        System.out.println("\nTotal number of names processed = " + size);
    }
}
