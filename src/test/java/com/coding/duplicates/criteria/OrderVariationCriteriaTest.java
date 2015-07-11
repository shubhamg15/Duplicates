package com.coding.duplicates.criteria;

import org.junit.Assert;
import org.junit.Test;

public class OrderVariationCriteriaTest {

    @Test
    public void should_find_the_duplicate_as_true_when_order_changed(){
        
        Assert.assertTrue(new OrderVariationCriteria().isDuplicate("garg shubham", "shubham garg"));
    
    }

    @Test
    public void should_find_the_duplicate_as_false_when_size_different(){
    
        Assert.assertFalse(new OrderVariationCriteria().isDuplicate("garg shubham xyz","shubham garg"));
    
    }
}