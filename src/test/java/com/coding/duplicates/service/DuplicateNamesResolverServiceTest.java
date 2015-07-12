package com.coding.duplicates.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class DuplicateNamesResolverServiceTest {

    @Test
    public void input_and_output_lists_should_contain_same_number_of_names() {

        List<String> inputList = asList("Shubham Garg", "B Turner", "B Kevin Turner", "Joey Jo", "Joel J");
        List<List<String>> outputList = new DuplicateNamesResolverService().groupDuplicateNameRecords(inputList);
        int size = 0;
        for (List<String> list : outputList) {
            size = size + list.size();
        }
        Assert.assertEquals(inputList.size(), size);
    }

}