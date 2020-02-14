
# ListSortApp

ListSortApp is a java application which performs the following sort functions on a list of integers:  
* Simple Sort:  sorts a list of integers into ascending or descending order
* Print Sorted Frequency:   prints a list of integers in ascending order, showing a count of each occurrence
* Number Of Unique Values:  returns a count of the unique items in a list of integers
<br/><br/> 

## Example View ##

```
 =================================================================================
 =========================   Integer Sorting Options   ===========================
 =================================================================================

 Print an ascending Simple Sort on your list:     Enter 'A' and a list of integers
 Print a descending Simple Sort on your list:     Enter 'B' and a list of integers
 Print a Sorted Frequency from your list:         Enter 'C' and a list of integers
 Print the Number of Unique Values in your list:  Enter 'D' and a list of integers
 Perform all of the above on your list:           Enter 'E' and a list of integers
 Use system data to run a test of all options:    Enter 'F'
 Exit:                                            Press <Enter>

 =================================================================================

 Usage examples:    A 45 97 -74 20 6 45 8 8 8 2 0 47 2
                    C 1654 6576 0
                    E 5 14 5 82 -6 4 98 5 -4 -6395 5 5 75

 User entry >>
 ```
<br/><br/> 

## Usage ##
 
As shown in the above view, enter a **space-delimited** entry as follows:
* type A followed by a series of numbers, then press `Enter`
   * this sorts the user's list of integers in ascending order
* type B followed by a series of numbers, then press `Enter`
   * this sorts the user's list of integers in descending order
* type C followed by a series of numbers, then press `Enter`
   * this sorts the user's list of integers in ascending order, then displays each integer with a count of how many times the integer occurred in the list.
* type D followed by a series of numbers, then press `Enter`
   * this returns a count of how many unique integers are in the user's list
* type E followed by a series of numbers, then press `Enter`
   * this runs all of the above sorts on the user's list and display the resulting info

**OR**

* type F, then press `Enter`:
   * this will auto-run all of the sorts on test data (to demo the output).  

**OR**

* press `Enter`:
   * this will exit the application.
 <br/><br/> 


### Example Output ###

A user entry of `E 5 14 5 82 -6 4 98 5 -4 -6395 5 5 75` produces the following output.


```

---------------------------------------------------------------------------------
Testing with this data:  [5, 14, 5, 82, -6, 4, 98, 5, -4, -6395, 5, 5, 75]
---------------------------------------------------------------------------------

Calling simpleSort ...
    Ascending sort: [-6395, -6, -4, 4, 5, 5, 5, 5, 5, 14, 75, 82, 98]
    Descending sort: [98, 82, 75, 14, 5, 5, 5, 5, 5, 4, -4, -6, -6395]


Calling printSortedFrequency ...
    -6395 appears 1 time
    -6 appears 1 time
    -4 appears 1 time
    4 appears 1 time
    5 appears 5 times
    14 appears 1 time
    75 appears 1 time
    82 appears 1 time
    98 appears 1 time


Calling numberOfUniqueValues ...
    The number of unique values is: 9
    
```
<br/><br/> 


## Prerequisites
Make sure that Java and [Git](https://git-scm.com) are installed on your computer and are referenced appropriately for your execution path.
<br/><br/> 
    
## Cloning the repository
Use the following URL to clone this repository:
```
https://github.com/shelllybean/GDDemo.git
```
<br/><br/> 


## Running the application from the command line

To compile and run the application, `cd` to the directory containing `com`, then enter the following commands:
```
javac com\lightf\codechallenge\*.java com\lightf\codechallenge\controllers\*.java
```
```
java com.lightf.codechallenge.ListSortApp
```
<br/><br/> 

 
## Running the application from within an IDE

To run the application within an IDE:
*   create a new Java Project within your IDE
*   copy the `com` directory into your new project's src folder
*   run the project as a java application

