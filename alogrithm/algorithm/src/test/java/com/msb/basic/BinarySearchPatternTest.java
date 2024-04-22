package com.msb.basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchPatternTest {
    private BinarySearchPattern target;

    @Before
    public void init() {
        this.target = new BinarySearchPattern();
    }

    @Test
    public void testFind() {
        int[] arr = {1,3,5,19,30,47,99,100,249};
        int target = 30;
        boolean result = this.target.find(arr, target);
        assertTrue(result);
        int target1 = 0;
        boolean result1 = this.target.find(arr, target1);
        assertTrue(!result1);
        int target2 = 300;
        boolean result2 = this.target.find(arr, target2);
        assertTrue(!result2);

        int[] arr1 = {1,3,5,5,5,5,19,30,47,99,100,249};
        int target3 = 5;
        boolean result3 = this.target.find(arr1, target3);
        assertTrue(result3);

        int[] arr2 = {1,1,1,1,1,1};
        int target4 = 5;
        boolean result4 = this.target.find(arr2, target4);
        assertTrue(!result4);
    }

    @Test
    public void testFindLeft() {
        int[] arr = {1,3,5,19,30,47,99,100,249};
        int target = 40;
        int result = this.target.findLeft(arr, target);
        assertEquals(5, result);
        int target1 = 0;
        int result1 = this.target.findLeft(arr, target1);
        assertEquals(0, result1);
        
        int[] arr1 = {1,3,5,5,5,5,19,30,47,99,100,249};
        int target3 = 5;
        int result3 = this.target.findLeft(arr1, target3);
        assertEquals(2, result3);

        int[] arr2 = {1,1,1,1,1,1};
        int target4 = 5;
        int result4 = this.target.findLeft(arr2, target4);
        assertEquals(-1, result4);
    }

    @Test
    public void testFindRight() {
        int[] arr = {1,3,5,19,30,47,99,100,249};
        int target = 40;
        int result = this.target.findRight(arr, target);
        assertEquals(4, result);
        int target1 = 300;
        int result1 = this.target.findRight(arr, target1);
        assertEquals(8, result1);
        
        int[] arr1 = {1,3,5,5,5,5,19,30,47,99,100,249};
        int target3 = 5;
        int result3 = this.target.findRight(arr1, target3);
        assertEquals(5, result3);

        int[] arr2 = {1,1,1,1,1,1};
        int target4 = 0;
        int result4 = this.target.findRight(arr2, target4);
        assertEquals(-1, result4);
    }
}
