package com.lintcode.daily;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Code75_FindPeakElementTest {
    private Code75_FindPeakElement target;
    
    @Before
    public void setup() {
        this.target = new Code75_FindPeakElement();
    }

    @Test
    public void testFindPeak() {
        int[] a = new int[] {1,2,1,2,3,1};
        int index = target.findPeak(a); 
        assertTrue(index == 1|| index == 4);
    }
}
