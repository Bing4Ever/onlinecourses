package com.lintcode.daily;

public class Code5_KthLargestElement {
    /**
     * @param k: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length-1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end){
            return nums[start];
        }

        int i = start;
        int j = end;
        int pivot = nums[(i+j)/2];
        while (i<=j) {
            while (i<=j && nums[i]>pivot) {
                i++;
            }
            while(i<=j && nums[j]<pivot) {
                j--;
            }

            if (i<=j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        if (start+k-1<=j) {
            return quickSelect(nums, start, j, k);
        }

        if (start+k-1>=i) {
            return quickSelect(nums, i, end, k-(i-start));
        }
        return nums[j+1];
    }
}
