package com.lightf.codechallenge;

import com.lightf.codechallenge.controllers.SortController;
import com.lightf.codechallenge.controllers.SortUtilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * TestUtilities provides functionality used while sorting
 *
 */
public class TestUtilities  {

    String BORDER = "------------------------------------------------------"
                    + "---------------------------";
    String SORT_TEXT = "\n\n\n\n\n" + BORDER + "\nSorting with this data:  "; 
    String TEST_TEXT = "\n\n\n\n\n" + BORDER + "\nTesting with this data:  "; 
    
    //
    // create an instance of the controller and the utilities class for the tests
    //
    SortController sc = new SortController();
    SortUtilities utils = new SortUtilities();


    //
    // call simpleSort with the specified parameters;
    // display results with descriptive text
    //
    public void callSimpleSort(int[] list, boolean ascendingFlag) {

        //
        // verify we have data
        //
	if (null == list || list.length == 0) {
	    return;
	}

        int[] arrayResult = null;	

	//
	// run the selected commands on the test data set
	//

        // header
	System.out.print(SORT_TEXT); 
	utils.printArray(list);
        System.out.println(BORDER);

        //
	// test simpleSort
	//
	System.out.print("    " + (ascendingFlag ? "Ascending" : "Descending") + " sort: "); 
        arrayResult = sc.simpleSort(list, ascendingFlag);
	utils.printArray(arrayResult);
    }

    //
    // call printSortedFrequency with the specified parameters;
    // display results with descriptive text
    //
    public void callPrintSortedFrequency(int[] list) {

        //
        // verify we have data
        //
	if (null == list || list.length == 0) {
	    return;
	}

        // header
	System.out.print(SORT_TEXT); 
	utils.printArray(list);
        System.out.println(BORDER);

	//
	// test printSortedFrequency
	//
	System.out.println("\n\nCalling printSortedFrequency ...");
        sc.printSortedFrequency(list);
    }

    //
    // call numberOfUniqueValue with the specified parameters;
    // display results with descriptive text
    //
    public void callNumberOfUniqueValues(int[] list) {

	int count = 0;

        //
        // verify we have data
        //
	if (null == list || list.length == 0) {
	    return;
	}

        // header
	System.out.print(SORT_TEXT); 
	utils.printArray(list);
        System.out.println(BORDER);

	//
	// test numberOfUniqueValues
	//
	System.out.println("\n\nCalling numberOfUniqueValues ...");
        count = sc.numberOfUniqueValues(list);
        System.out.println("    The number of unique values is: " + count);
    }

    //
    // call all 3 sort routines with the specified parameters;
    // display results with descriptive text
    //
    public void performAllSortTests(int[] list) {

        //
        // verify we have data
        //
	if (null == list || list.length == 0) {
	    return;
	}

	int count = 0;
        int[] arrayResult = null;	

        // header
	System.out.print(TEST_TEXT); 
	utils.printArray(list);
        System.out.println(BORDER);
   
        //
	// test simpleSort, both ascending and descending
	//
	System.out.println("\nCalling simpleSort ...");
	    
	System.out.print("    Ascending sort: "); 
        arrayResult = sc.simpleSort(list, true);
	utils.printArray(arrayResult);
   
        System.out.print("    Descending sort: "); 
        arrayResult = sc.simpleSort(list, false);
	utils.printArray(arrayResult);
            
	//
	// test printSortedFrequency
	//
	System.out.println("\n\nCalling printSortedFrequency ...");
        sc.printSortedFrequency(list);
    
	//
	// test numberOfUniqueValues
	//
	System.out.println("\nCalling numberOfUniqueValues ...");
        count = sc.numberOfUniqueValues(list);
        System.out.println("    The number of unique values is: " + count);
    }


    //
    // call all 3 sort routines using test data
    // display results with descriptive text
    //
    public void autoRunTests() {

	//
	// test data setup
	//
        int[] sortList1 = new int[] { 24, 12, 19, 12, 8 , 12, 94, -2, 340, 0};
        int[] sortList2 = new int[] { 34, 79, 11, -5, 20000, 0, 4, 0, 22, 1 };
        int[] sortList3 = new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
        int[] sortList4 = null;
        int[] sortList5 = new int[] {1, 10, 11, 5, 9, 3, 2, 4, 200, 7};
        int[] sortList6 = new int[] {5};
        int[] sortList7 = new int[] {};
	
        int data[][] = {sortList1};

	//
	// for internall testing
	//
        int data2[][] = { sortList1, sortList2, sortList3, sortList4, sortList5, 
		         sortList6, sortList7 };

	//
	// run each of the 3 sort commands on each array in the test data set
	//
        for(int[] list : data) {
            performAllSortTests(list);    
	}
    }
}
