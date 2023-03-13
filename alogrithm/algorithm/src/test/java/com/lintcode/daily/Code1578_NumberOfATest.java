package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code1578_NumberOfATest {
    private Code1578_NumberOfA target;

    @Before
    public void setup() {
        this.target = new Code1578_NumberOfA();
    }

    @Test
    public void testCountA() {
        String input = "BBAACCDDD";
        int count = target.countA(input);
        assertEquals(2, count);
    }
}
