package org.example;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void testLinealSearch() {
        String[] listNumbers = {"1", "2", "3", "4", "5"};
        assertEquals(2, Calculator.LinealSearch(listNumbers, "3"));
        assertEquals(-1, Calculator.LinealSearch(listNumbers, "6"));
    }
    
    public void testBinarySearch() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, Calculator.BinarySearch(arr, 5));
        assertEquals(-1, Calculator.BinarySearch(arr, 4));
    }
    
}
