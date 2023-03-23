package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code693_RemoveDigitsTest {
    private Code693_RemoveDigits target;

    @Before
    public void setup() {
        this.target = new Code693_RemoveDigits();
    }

    @Test
    public void testRemoveKdigits() {
        String num = "149213";
        int k = 3;
        String result = target.removeKdigits(num, k);
        assertEquals("113", result);
    }
}
