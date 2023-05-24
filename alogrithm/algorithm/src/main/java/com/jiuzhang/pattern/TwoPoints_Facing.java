package com.jiuzhang.pattern;

public class TwoPoints_Facing {
    public void quickSort(int[] a, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = a[(start+end)/2];
        while (left <= right) {
            while (left <= right && a[left]<pivot) {
                left++;
            }
            while( left<= right && a[right]>pivot) {
                right--;
            }
            if (left<=right) {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
                left++;
                right--;
            }
        }
        quickSort(a, start, right);
        quickSort(a, left, end);
    }
}
