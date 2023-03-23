package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code740_CoinChange2Test {
    private Code740_CoinChange2 target;

    @Before
    public void setup() {
        this.target = new Code740_CoinChange2();
    }


    @Test
    public void testChange() {
        int amount = 8;
        int[] coins = {2,3,8};
        int result = this.target.change(amount, coins);
        assertEquals(3, result);
    }
}
