package com.lintcode.daily;

/**
 * Find a peak element in this array. Return the index of the peak.
 * <p>https://www.lintcode.com/problem/75/</p>
 */
public class Code75_FindPeakElement {
    /**
     * @param a: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] a) {
        if (a.length == 1) {
            return 0;
        }

        // write your code here
        int start = 0;
        int end = a.length-1;
        while (start < end) {
            int mid = start+(end-start)/2;
            if (a[mid]>=a[mid-1] && a[mid]<=a[mid+1]) {
                start = mid;
            } else if (a[mid]<=a[mid-1] && a[mid]>=a[mid+1]) {
                end = mid;
            } else if (a[mid]<=a[mid-1] && a[mid] <= a[mid+1]){
                start = mid;
            } else {
                start = mid;
                break;
            }
        }

        return a[start]>=a[end]?start:end;
    }
}
