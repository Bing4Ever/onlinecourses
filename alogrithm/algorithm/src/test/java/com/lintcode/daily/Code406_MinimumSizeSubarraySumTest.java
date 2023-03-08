package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code406_MinimumSizeSubarraySumTest {
    private Code406_MinimumSizeSubarraySum target;

    @Before
    public void setup() {
        this.target = new Code406_MinimumSizeSubarraySum();
    }

    @Test
    public void testMinimumSize() {
        int[] input = new int[]{100,50,99,50,100,50,99,50,100,50};
        int s = 250;
        int result = target.minimumSize(input, s);
        assertEquals(2, result);
    }
}
