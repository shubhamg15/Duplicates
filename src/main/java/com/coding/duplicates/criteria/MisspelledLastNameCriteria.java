package com.coding.duplicates.criteria;

import com.coding.duplicates.service.FirstNameValidator;
import com.coding.duplicates.util.LevenshteinDistance;

import java.util.List;

import static java.util.Arrays.asList;

public class MisspelledLastNameCriteria implements DuplicateCriteria {

    private static int PERMISSIBLE_LETTER_ERROR_COUNT = 1;

    @Override
    public boolean isDuplicate(String nameOne, String nameTwo) {

        List<String> splitNameOne = asList(nameOne.split(" "));
        List<String> splitNameTwo = asList(nameTwo.split(" "));

        if (FirstNameValidator.validateForSameNames(splitNameOne.get(0), splitNameTwo.get(0))) {
            return isLastNameMisspelled(getLastName(splitNameOne), getLastName(splitNameTwo), PERMISSIBLE_LETTER_ERROR_COUNT);
        }
        return false;
    }

    private String getLastName(List<String> splitNameOne) {
        return splitNameOne.get(splitNameOne.size() - 1);
    }

    private boolean isLastNameMisspelled(String nameOne, String nameTwo, int permissibleMistakes) {
        return LevenshteinDistance.computeLevenshteinDistance(nameOne, nameTwo) <= permissibleMistakes;
    }
}
