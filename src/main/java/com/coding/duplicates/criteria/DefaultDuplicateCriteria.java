package com.coding.duplicates.criteria;

public class DefaultDuplicateCriteria implements DuplicateCriteria {

    @Override
    public boolean isDuplicate(String nameOne, String nameTwo) {
        return nameOne.equals(nameTwo);
    }
}
