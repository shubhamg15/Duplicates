package com.coding.duplicates.criteria;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MissingMiddleNameCriteria implements DuplicateCriteria{

    @Override
    public boolean isDuplicate(String nameOne, String nameTwo) {
        
        List<String> splitNameOne = new LinkedList<String>(asList(nameOne.split(" ")));
        List<String> splitNameTwo = new LinkedList<String>(asList(nameTwo.split(" ")));

        if(splitNameOne.size() == 3 && splitNameTwo.size() == 2){
            return compareForDuplicate(splitNameOne, splitNameTwo);
        } else if(splitNameOne.size() == 2 && splitNameTwo.size() == 3){
            return compareForDuplicate(splitNameTwo, splitNameOne);
        }
        return false;
    }

    private boolean compareForDuplicate(List<String> longPart, List<String> shortPart) {
        longPart.remove(1); //removing middle name from the longer name
        return longPart.equals(shortPart);
    }
}
