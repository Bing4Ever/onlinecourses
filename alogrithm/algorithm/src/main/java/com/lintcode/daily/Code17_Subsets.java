package com.lintcode.daily;

import java.util.*;

/**
 * https://www.lintcode.com/problem/17/
 */
public class Code17_Subsets {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     *          we will sort your return value in output
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i=startIndex; i<nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i+1, subset, result);
            subset.remove(subset.size()-1);
        }
        
    }
}
