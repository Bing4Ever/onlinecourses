package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code669_CoinChangeTest {
    private Code669_CoinChange target;

    @Before
    public void setup() {
        this.target = new Code669_CoinChange();
    }
    
    @Test
    public void testCoinChange() {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        int result = target.coinChange(coins, amount);
        assertEquals(3, result);
    }
}
