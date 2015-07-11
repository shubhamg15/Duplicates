package com.coding.duplicates.main;

import com.coding.duplicates.service.DuplicateNamesResolverService;
import com.coding.duplicates.util.FileParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DuplicateNamesResolver {

    public static List<String> inputNames = FileParser.parseFileByLine("names.input");
    
    public static void main(String[] args) {
        
        List<List<String>> namesList = new ArrayList<List<String>>();
        for(String name: inputNames){
            namesList.add(new ArrayList<String>(Arrays.asList(name)));
        }
        
        new DuplicateNamesResolverService().groupDuplicateNameRecords(namesList);

        Collections.sort(namesList, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> a, List<String> b) {
                return new Integer(b.size()).compareTo(a.size());
            }
        });
        int size =0;
        for (List<String> duplicates : namesList) {
            System.out.println(duplicates);
            size = size + duplicates.size();
        }
        System.out.println("Size = "+size);
    }
}
