package com.msb.basic;

/**
 * <p>All the parttern with binary search.</p>
 */
public class BinarySearchPattern {

    public boolean find(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[mid] > target) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return false;
    }

    public int findLeft(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1; 
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr[mid] >= num) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int findRight(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr[mid]<= num) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /*
     * 寻找局部最小
     */
    public int oneMinindex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr[0]<arr[1]) {
            return 0;
        }
        int n = arr.length-1;
        if (arr[n-1]>arr[n]){
            return n;
        }
        int left = 0;
        int right = n; 
        while (left < right-1) {
            int mid = left+(right-left)/2;
            if (arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1]) {
                return mid;
            }
            if (arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1]) {
                left = mid +1;
            } else  {
                right = mid -1; 
            }
        }

        return arr[left]<arr[right]?arr[left]:arr[right];

    }

}
