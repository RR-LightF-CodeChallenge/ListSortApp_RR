package com.lightf.codechallenge.controllers;


/**
 * SortChallenge is an interface for sorting integer arrays
 *
 */
public interface SortChallenge {

    public int[] simpleSort(int[] list, boolean ascending);

    public void printSortedFrequency(int[] list);

    public int numberOfUniqueValues(int[] list);
}

