package com.lintcode.daily;

public class Code521_RemoveDuplicateNumbersinArray {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null|| nums.length ==0) {
            return 0;
        }

        int i=0;
        int j=1;
        for (;i<nums.length;i++) {
            while (j<nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j>= nums.length){
                break;
            }
            nums[i+1] = nums[j];
        }
        return i+1;
    }
}
