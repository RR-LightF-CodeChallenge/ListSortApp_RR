package com.lightf.codechallenge;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.InterruptedException;

/**
 * ListSortApp application performs sorting on integer arrays as follows: 1.
 * sorts an array, either ascending or descending based on a flag 2. counts the
 * number of unique values contained in an array 3. prints each element of an
 * array and a count of its occurrence
 *
 * The application can run an auto-test of its sorting routines with its pre-set
 * data or, can sort user-entered data.
 *
 * Usage: java ListSortApp (for external use) java ListSortApp 1 (internal tests
 * will run and display output) java ListSortApp 2 (user is prompted to enter
 * data to test app)
 * 
 */
public class ListSortApp {

	public static void main(String[] args) throws InterruptedException, IOException {

		int count = 0;
		int[] intArray;
		String input = null;
		String option = null;
		boolean exit = false;
		String[] arrayElements;
		TestUtilities tester = new TestUtilities();

		String WAIT_TO_CONTINUE = "\n\n\n Press <Enter> to continue...\n";

		String PROMPT = " User entry: ";

		String MENU = "\n\n\n\n\n\n\n"
				+ " =================================================================================\n"
				+ " =========================   Integer Sorting Options   ===========================\n"
				+ " =================================================================================\n\n"
				+ " Print an ascending Simple Sort on your list:     Enter 'A' and a list of integers\n"
				+ " Print a descending Simple Sort on your list:     Enter 'B' and a list of integers\n"
				+ " Print a Sorted Frequency from your list:         Enter 'C' and a list of integers\n"
				+ " Print the Number of Unique Values in your list:  Enter 'D' and a list of integers\n"
				+ " Perform all of the above on your list:           Enter 'E' and a list of integers\n"
				+ " Use system data to run a test of all options:    Enter 'F'\n"
				+ " Exit:                                            Press <Enter>\n\n"
				+ " =================================================================================\n\n"
				+ " Usage examples:    A 45 97 -74 20 6 45 8 8 8 2 0 47 2\n" 
				+ "                    C 1654 6576 0\n"
				+ "                    E 5 14 5 82 -6 4 98 5 -4 -6395 5 5 75\n\n";

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			System.out.print(MENU);

			//
			// continue displaying the menu and/or prompt until the user chooses to exit
			//
			while (exit == false) {

				System.out.print(PROMPT);

				try {

					//
					// open standard input for reading user's data
					//
					input = br.readLine();

				} catch (IOException e) {
					//
					// if there was any issue reading the user's info, exit
					//
					System.out.println(" An error occurred with the entry data ... exiting.");
					exit = true;
					System.exit(1);
				}

				//
				// nothing was entered; this is the exit option, so exit
				//
				if ((null == input) || (input.length() == 0)) {
					exit = true;
					System.exit(1);
				}

				// trim, then split the input on spaces
				input = input.trim();
				arrayElements = input.split(" ");

				//
				// verify the first character of the entry is one of the valid options. (A, B,
				// C, D, E, F)
				//
				if (!((arrayElements[0].length() == 1) && ("ABCDEF".contains(arrayElements[0].toUpperCase())))) {
					System.out.println("\n\n !!!!! An invalid option was selected."
							+ "\n See usage examples above, and try again.\n\n\n");
					continue;
				}

				//
				// verify that, if F is selected, no numbers have been provided
				//
				if (("F".equalsIgnoreCase(arrayElements[0])) && (arrayElements.length > 1)) {
					System.out.println("\n\n !!!!! A list of integers should not be included with this option."
							+ "\n See usage examples above, and try again.\n\n\n");
					continue;
				}

				//
				// verify that, if any option other than F is selected, a list of numbers has
				// been provided
				//
				if ((arrayElements.length < 2) && (!"F".equalsIgnoreCase(arrayElements[0]))) {
					System.out.println("\n\n !!!!! A list of integers must be provided."
							+ "\n See usage examples above, and try again.\n\n\n");
					continue;
				}

				//
				// we now know the option selected and the length for the integer array
				//
				option = arrayElements[0].toUpperCase();
				intArray = new int[arrayElements.length - 1];
				count = 0;

				//
				// create the array of integers from the user's input
				//
				for (int i = 1; i < arrayElements.length; i++) {

					try {
						intArray[count] = Integer.parseInt(arrayElements[i]);
						count++;
					} catch (NumberFormatException nfe) {

						System.out.println("\n\n !!!!! An invalid or non-integer value was entered.");
						System.out.println(" See example usage above, and try again.\n\n\n");
						continue;
					}
				}

				//
				// we successfully parsed the user's option and integer array;
				// perform the chosen option
				//
				switch (option) {

				case "A":
					tester.callSimpleSort(intArray, true); // ascending sort
					break;
				case "B":
					tester.callSimpleSort(intArray, false); // descending sort
					break;
				case "C":
					tester.callPrintSortedFrequency(intArray);
					break;
				case "D":
					tester.callNumberOfUniqueValues(intArray);
					break;
				case "E":
					tester.performAllSortTests(intArray);
					break;
				case "F":
					tester.autoRunTests();
					break;
				default:
					tester.autoRunTests();
				}

				System.out.println(WAIT_TO_CONTINUE);

				input = br.readLine();

				System.out.print(MENU);

				continue;

			} // while
		} // try
	} // main
}
