package com.lintcode.daily;

import java.util.Arrays;

/**
 * 
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * <p>https://www.lintcode.com/problem/669/</p>
 * dp[i][j]=max(dp[i−1][j],dp[i−1][j−k∗coin[i]]+k)(0≤k∗coin[i]≤j)
 */
public class Code669_CoinChange {
    private int level;
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i=1; i<= amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

     
}
