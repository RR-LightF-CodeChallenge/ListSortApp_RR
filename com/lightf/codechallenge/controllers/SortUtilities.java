package com.lightf.codechallenge.controllers;

/**
 * SortUtilities provides functionality used while sorting
 *
 */
public class SortUtilities {

	//
	// getFrequencyLines:
	//
	// list: the array of integers
	// useUniqueCountFlag: indicates if we're asking for only a count
	//
	//
	// returns a string based on the useUniqueCountFlag value:
	//
	// if the flag is true, it returns a string containing a
	// count of the unique integers in the list
	//
	// if the flag is false, it returns a string containing each
	// integer of the list and a count of its occurrences in the list
	//
	String getFrequencyLines(int[] list, boolean useUniqueCountFlag) {

		String str = ""; // will hold the string to be returned
		int[] sortedResult = null; // the list after it has been sorted
		boolean ascending = true; // we will sort the list ascendingly
		int previous = -1; // holds the previous place in the array
		int count = 0; // the number of unique integers in the list

		//
		// handle cases where no data was passed
		//
		if (null == list) {
			// return nothing; an appropriate message is displayed elsewhere
		} else if (list.length == 0) {
			str += "    No integers were detected.";
		} else {

			//
			// perform the sort
			//
			sortedResult = sort(list, ascending);

			//
			// create context for each item in the list and handle plurals
			//
			for (int i = 0; i < sortedResult.length; i++) {

				if (i == sortedResult.length - 1 || sortedResult[i] != sortedResult[i + 1]) {

					str += "    " + sortedResult[i] + " appears " + (i - previous)
							+ ((i - previous) > 1 ? " times" : " time") + "\n";

					previous = i;
					count++;
				}
			}
		}

		return (useUniqueCountFlag ? Integer.toString(count) : str);
	}

	//
	// prints the array with braces; for calls with no prepended text
	//
	// array: the list/array of integers
	//
	public void printArray(int[] array) {

		String prependText = "";
		printArray(array, prependText);
	}

	//
	// prints the list with braces; for calls with no prepended text
	//
	// list: the list of integers
	// prependText: text to prepend to the list
	//
	public void printArray(int[] list, String prependText) {

		if (null == list) {

			System.out.println("\nError: Received null input!");

		} else {

			int len = list.length;

			if (null == prependText) {
				prependText = "";
			}

			System.out.print(prependText + "[");

			for (int i = 0; i < len; i++) {

				if (i != len - 1) {
					System.out.print(list[i] + ", ");
				} else {
					System.out.print(list[i]);
				}
			}
			System.out.println("]");
		}
	}

	//
	// perform an insertion sort: sufficient for short lists
	//
	// list: the integer list to be sorted
	// ascending: flag indicating if sort should be ascending or descending
	//
	// returns the sorted list
	//
	int[] sort(int[] list, boolean ascending) {

		int j;
		int value; // the current list item
		int order; // multiply to make the number + or - based on the desired sort

		for (int i = 1; i < list.length; i++) {

			value = list[i];
			j = i - 1;
			order = (ascending ? 1 : -1);

			while ((j >= 0) && ((list[j] * order) > (value * order))) {

				list[j + 1] = list[j];
				j = j - 1;
			}

			list[j + 1] = value;
		}

		return list;
	}
}
