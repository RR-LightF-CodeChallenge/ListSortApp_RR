package com.lightf.codechallenge.controllers;


/**
 * SortController implements the sort routines provided in SortChallenge.
 * It performs sorts on integer arrays
 *
 */
public class SortController implements SortChallenge {

    SortUtilities utils = new SortUtilities();

    //
    //  simpleSort: returns a count of unique numbers in an array
    //  
    //  list: the array of integers
    //  ascending: flag to indicate if the sort should be ascending
    //  
    //  returns the sorted array
    //
    public int[] simpleSort(int[] originalList, boolean sortAscending) {

	int[] sortedList = null;

        if (null != originalList) {
	    sortedList = utils.sort(originalList, sortAscending);
	}

        return sortedList;
    }


    //
    // printSortedFrequency: prints the occurrence count for each number in an array
    // 
    // list: the array of integers
    //
    public void printSortedFrequency(int[] originalList) {

	boolean useUniqueCountFlag = false;

	System.out.println(utils.getFrequencyLines(originalList, useUniqueCountFlag));
    }


   
    //
    // numberOfUniqueValues: returns a count of unique numbers in an array
    // 
    // list: the array of integers
    // 
    // returns a count of the unique integers within the array
    //
    public int numberOfUniqueValues(int[] originalList) {

        int count = 0;
	boolean useUniqueCountFlag = true;

	try {
	    count = Integer.parseInt(utils.getFrequencyLines(originalList, useUniqueCountFlag));
	} catch (NumberFormatException nfe) {
            // something went wrong while getting this count;  use zero
	    count = 0;
	}

        return count;
    }
}
