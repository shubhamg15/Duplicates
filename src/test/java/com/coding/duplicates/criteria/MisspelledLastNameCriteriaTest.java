package com.coding.duplicates.criteria;

import org.junit.Assert;
import org.junit.Test;

public class MisspelledLastNameCriteriaTest {

    @Test
    public void should_find_the_duplicate_as_true_when_last_name_is_mispelled_by_one_letter() {
        Assert.assertTrue(new MisspelledLastNameCriteria().isDuplicate("shubham garg", "shubham garg"));
    }

    @Test
    public void should_find_the_duplicate_as_false_when_last_name_misspelled_by_more_than_one_letters() {
        Assert.assertFalse(new MissingMiddleNameCriteria().isDuplicate("shubham gaaarg", "shubham gargaf"));
    }
}