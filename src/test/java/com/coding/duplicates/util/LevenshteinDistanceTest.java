package com.coding.duplicates.util;


import junit.framework.Assert;
import org.junit.Test;

public class LevenshteinDistanceTest {

    @Test
    public void should_return_appropriate_distance_values() {

        Assert.assertEquals(1, LevenshteinDistance.computeLevenshteinDistance("shubham", "shubhamm"));
        Assert.assertEquals(1, LevenshteinDistance.computeLevenshteinDistance("shubham", "shubhm"));
        Assert.assertEquals(1, LevenshteinDistance.computeLevenshteinDistance("shubham", "shubhzm"));

        Assert.assertEquals(2, LevenshteinDistance.computeLevenshteinDistance("shubham", "shbhamm"));
        Assert.assertEquals(2, LevenshteinDistance.computeLevenshteinDistance("shubham", "shubhmp"));
        Assert.assertEquals(2, LevenshteinDistance.computeLevenshteinDistance("shubham", "shubh"));

        Assert.assertEquals(3, LevenshteinDistance.computeLevenshteinDistance("shubham", "bham"));
        Assert.assertEquals(3, LevenshteinDistance.computeLevenshteinDistance("shubham", "shubhjul"));
        Assert.assertEquals(3, LevenshteinDistance.computeLevenshteinDistance("shubham", "shubhamxcv"));

    }
}