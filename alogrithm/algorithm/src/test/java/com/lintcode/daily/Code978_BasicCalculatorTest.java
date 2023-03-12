package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code978_BasicCalculatorTest {
    private Code978_BasicCalculator target;

    @Before
    public void setup() {
        this.target = new Code978_BasicCalculator();
    }

    @Test
    public void testCalculate() {
        String input = "2+3 + 5";
        int result = target.calculate(input);
        assertEquals(10, result);
    }
}
