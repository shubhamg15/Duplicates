package com.coding.duplicates.service;

import com.coding.duplicates.criteria.DefaultDuplicateCriteria;
import com.coding.duplicates.criteria.DuplicateCriteria;
import com.coding.duplicates.criteria.MissingMiddleNameCriteria;
import com.coding.duplicates.criteria.MisspelledLastNameCriteria;
import com.coding.duplicates.criteria.OrderVariationCriteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class DuplicateNamesResolverService {

    // Note - this could be injected using spring @autowire, but just to keep the project spring dependency free writing it the following ugly way :)
    private static List<DuplicateCriteria> duplicateCriterias = asList(new DefaultDuplicateCriteria(),
                                                                       new OrderVariationCriteria(),
                                                                       new MissingMiddleNameCriteria(),
                                                                       new MisspelledLastNameCriteria());

    public List<List<String>> groupDuplicateNameRecords(List<String> inputNameList) {

        //Create a list of lists - Sub list contains the duplicate records (initially every sub list has one name)
        List<List<String>> namesList = new ArrayList<List<String>>();
        for(String name: inputNameList){
            namesList.add(new ArrayList<String>(Arrays.asList(name)));
        }
        
        //iterate each element from list and match for duplicates with rest of the other elements (only in forward direction)
        for (int i = 0; i < namesList.size(); i++) {
            matchForDuplicates(namesList, i);
        }
        return namesList;
    }

    private void matchForDuplicates(List<List<String>> namesList, int i) {

        for (int j = i + 1; j < namesList.size(); j++) {
            
            for (DuplicateCriteria criteria : duplicateCriterias) {
                
                if(criteria.isDuplicate(getNameFromIndex(namesList, i), getNameFromIndex(namesList, j))){
                   
                    addDuplicateNameToChildList(namesList.get(i), getNameFromIndex(namesList, j));
                    
                    namesList.remove(j); // remove the duplicate from original parent list after adding it to child list
                    
                    j--; // decrement loop counter since an element got deleted from the list that we are iterating on
                    break;
                }
            }
        }
    }

    private void addDuplicateNameToChildList(List<String> namesListRecord, String duplicateNameElement) {
        namesListRecord.add(duplicateNameElement);
    }

    private String getNameFromIndex(List<List<String>> namesList, int i) {
        return namesList.get(i).get(0);
    }
}
