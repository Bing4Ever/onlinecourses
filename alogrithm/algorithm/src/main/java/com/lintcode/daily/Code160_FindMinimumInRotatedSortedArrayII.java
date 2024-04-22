package com.lintcode.daily;

/**
 * <p>https://www.lintcode.com/course/30/learn/160?chapterId=151&sectionId=2106&ac=false</p>
 */
public class Code160_FindMinimumInRotatedSortedArrayII {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = (left + right) /2;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right = right-1;
            }
        }
        return nums[left];
    }
}
