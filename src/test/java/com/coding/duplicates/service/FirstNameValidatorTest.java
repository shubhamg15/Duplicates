package com.coding.duplicates.service;

import org.junit.Assert;
import org.junit.Test;

public class FirstNameValidatorTest {
    
    @Test
    public void should_find_the_duplicate_as_true_when_names_are_same() {
        Assert.assertTrue(new FirstNameValidator().validateForSameNames("shubham", "shubham"));
    }

    @Test
    public void should_find_the_duplicate_as_true_when_names_belong_to_sam_list() {
        Assert.assertTrue(new FirstNameValidator().validateForSameNames("Abraham", "Bram"));
        Assert.assertTrue(new FirstNameValidator().validateForSameNames("Chester", "Chet"));
    }

    @Test
    public void should_find_the_duplicate_as_false_when_names_vary() {
        Assert.assertFalse(new FirstNameValidator().validateForSameNames("abc", "Cecie"));
    }
}