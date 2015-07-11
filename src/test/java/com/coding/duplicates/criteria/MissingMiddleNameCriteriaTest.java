package com.coding.duplicates.criteria;

import org.junit.Assert;
import org.junit.Test;

public class MissingMiddleNameCriteriaTest {

    @Test
    public void should_find_the_duplicate_as_true_when_middle_name_missing() {
        Assert.assertTrue(new MissingMiddleNameCriteria().isDuplicate("shubham xyz garg", "shubham garg"));
        Assert.assertTrue(new MissingMiddleNameCriteria().isDuplicate("shubham garg", "shubham xyz garg"));
    }

    @Test
    public void should_find_the_duplicate_as_false() {
        Assert.assertFalse(new MissingMiddleNameCriteria().isDuplicate("shubham xyz gaaarg", "shubham garg"));
    }
}