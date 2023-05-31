package com.jiuzhang.pattern;

import java.util.*; 

public class DFS {
    public List<List<Integer>> premute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] nums, boolean[] visit, List<Integer> premutation, List<List<Integer>> result) {
        if (premutation.size() == nums.length) {
            result.add(new ArrayList<Integer>(premutation));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (visit[i]) {
                continue;
            }

            premutation.add(nums[i]);
            visit[i] = true;
            dfs(nums, visit, premutation, result);
            visit[i] = false;
            premutation.remove(premutation.size()-1);
        }
    }

    public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), result);
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
