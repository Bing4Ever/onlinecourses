package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code392_HouseRobberTest {
    private Code392_HouseRobber target;

    @Before
    public void setup() {
        this.target = new Code392_HouseRobber();
    }

    @Test
    public void testHouseRobber() {
        int[] a = new int[]{5, 2, 1, 3};
        long amount = target.houseRobber(a);
        assertEquals(8L, amount);
    }
}
