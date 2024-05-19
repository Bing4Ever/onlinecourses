package com.msb.basic;

public class QuickSort {

    public void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process3(arr, 0, arr.length-1);
    }

    private void process2(int[] arr, int l, int r){
        if (l >= r) {
            return;
        }

        int[] equalArea = netherlandsFlag(arr, l, r);
        process3(arr, l, equalArea[0]-1);
        process3(arr, equalArea[1]+1, r);
    }

    private void process3(int[] arr, int l, int r){
        if (l >= r) {
            return;
        }

        // to get a random number as the pivot and put it to the end of the arr
        swap(arr, l+(int)(Math.random() * (r-l+1)), r);
        int[] equalArea = netherlandsFlag(arr, l, r);
        process3(arr, l, equalArea[0]-1);
        process3(arr, equalArea[1]+1, r);
    }

    public int[] netherlandsFlag(int[] arr, int l, int r){
        if (l > r){
            return new int[] {-1, -1};
        }

        if (l == r) {
            return new int[] {l, r};
        }

        int less = l -1;
        int more = r;
        int index = l;
        while (index < more) {
            if (arr[index] == arr[r]) {
                index++;
            } else if (arr[index] < arr[r]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, r);
        return new int[] {less+1, more};
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
