package com.lintcode.daily;

import java.util.*;

/**
 * https://www.lintcode.com/problem/18/
 * 
 */
public class Code18_SubsetsII {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     *          we will sort your return value in output
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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

        for(int i=startIndex; i<nums.length;i++) {
            if (i!=0 && nums[i] == nums[i-1] && i>startIndex) {
                continue;
            }
            subset.add(nums[i]);
            dfs(nums, i+1, subset, result);
            subset.remove(subset.size()-1);
        }
    }
}
