package com.jiuzhang.pattern;

public class Partition {
    public void partition(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;

        int pivot = arr[(start+end)/2];

        while (left <= right) {
            while (left <=right && arr[left]<pivot) {
                left++;
            }
            while (left <= right && arr[right]>pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        partition(arr, start, right);
        partition(arr, left, end);
    }   
    
}
