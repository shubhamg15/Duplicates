package com.coding.duplicates.criteria;


import java.util.HashSet;

import static java.util.Arrays.asList;

public class OrderVariationCriteria implements DuplicateCriteria {

    @Override
    public boolean isDuplicate(String nameOne, String nameTwo) {

        HashSet<String> nameSplitOne = new HashSet<String>(asList(nameOne.split(" ")));
        HashSet<String> nameSplitTwo = new HashSet<String>(asList(nameTwo.split(" ")));

        if (nameSplitOne.size() == nameSplitTwo.size()) {
            return nameSplitOne.containsAll(nameSplitTwo);
        }
        return false;
    }
}
