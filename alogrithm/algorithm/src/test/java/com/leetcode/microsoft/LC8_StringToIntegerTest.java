package com.leetcode.microsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LC8_StringToIntegerTest {
    private LC8_StringToInteger target;

    @Before
    public void setup() {
        this.target = new LC8_StringToInteger();
    }

    @Test
    public void testMyAtoi() {
        String tc = "4193 with words";
        int actual = target.myAtoi(tc);
        int expected = 4193;
        assertEquals(expected, actual);
    }

    @Test
    public void testMyAtoiWithLargeNumber() {
        String tc = "-91283472332";
        int actual = target.myAtoi(tc);
        int expected = Integer.MIN_VALUE;
        assertEquals(expected, actual);
    }

    @Test
    public void testMyAtoiWithEmpty() {
        String tc = " ";
        int actual = target.myAtoi(tc);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMyAtoiTC4() {
        String tc = "00000-42a1234";
        int actual = target.myAtoi(tc);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testMyAtoiTC5() {
        String tc = "  -0012a42";
        int actual = target.myAtoi(tc);
        int expected = -12;
        assertEquals(expected, actual);
    }
}
