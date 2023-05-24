package com.lintcode.daily;

import javax.lang.model.element.QualifiedNameable;

public class Code464_SortIntegersII {
    /**
     * @param a: an integer array
     * @return: nothing
     */
    public void Code464_SortIntegersII(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        quickSort(a, 0, a.length-1);
    }

    private void quickSort(int[] a, int start, int end) {
        if (start > end) {
            return;
        }

        int left = start;
        int right = end;
        int pivot = a[(start+end)/2];
        while (left <= right) {
            while (left<=right && a[left]<pivot) {
                left++;
            }
            while (left<=right && a[right]>pivot) {
                right--;
            }
            if (left <= right) {
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
