package com.lintcode.daily;


/*
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.
 */
public class Code406_MinimumSizeSubarraySum {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        int left = 0, currSum = 0, res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            while (currSum >= s) {
                res = Math.min(res, right-left+1);
                currSum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE?-1:res;
    }
}
