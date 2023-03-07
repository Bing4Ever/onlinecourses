package com.lintcode.daily;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>https://www.lintcode.com/problem/392/</p>
 */
public class Code392_HouseRobber {
    /**
     * @param a: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] a) {
        if (a==null || a.length == 0) {
            return 0;
        }
        if (a.length < 2) {
            return (long)a[0];
        }
        // write your code here
        long[] dp = new long[a.length];
        Arrays.fill(dp, a[0]);

        dp[1] = a[0]>a[1]?a[0]:a[1];
        if (a.length == 2) {
            return dp[1];
        }
        for (int i=2; i<dp.length;i++) {
            dp[i] = Math.max(dp[i-2]+a[i], dp[i-1]);
        }
        return dp[dp.length-1];

    }
}
