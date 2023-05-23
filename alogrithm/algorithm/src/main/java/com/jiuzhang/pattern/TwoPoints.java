package com.jiuzhang.pattern;

import java.util.*;

public class TwoPoints {
    public int[] twoSum(int[] nums, int target) {
        int j = 1;
        for (int i=0; i< nums.length; i++) {
            j = Math.max(j, i+1);
            while (j<nums.length && nums[j]-nums[i]<target) {
                j++;
            }
            if (j>nums.length) {
                break;
            }
            if (nums[j] - nums[i] == target) {
                return new int[] {i, j};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Count none zero characters
     * @param str
     * @return
     */
    public int stringCount(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int ans = 0;
        int j = 1;
        for (int i=0; i<str.length(); i++) {
            if(str.charAt(i) != '0') {
                continue;
            }
            j = Math.max(j, i+1);
            while (j<str.length() && str.charAt(j)=='0') {
                j++;
            }

            ans += (j - i);
        }
        return ans;
    }

    public int deduplication(int[] nums) {
        if (nums == null){
            return 0;
        }
        int j = 1;
        int i=0;
        Arrays.sort(nums);
        for (; i<nums.length; i++) {
            j = Math.max(j,i+1);
            while (j<nums.length && nums[j] == nums[i]){
                j++;
            }
            if (j>nums.length) {
                break;
            }
            nums[i+1] = nums[j];
        }
        return i+1;
    }
}
