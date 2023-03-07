package com.lintcode.daily;

public class Code34_NQueenII {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        int result = process(0, n, new int[n]);
        return result;
    }

    private int process(int index, int n, int[] record) {
        if (index == n) {
            return 1;
        }
        int res = 0;
        for (int i=0; i<n; i++){
            if (isValid(record, index, i)) {
                record[index] = i;
                res +=process(index+1, n, record);
            }
        }
        return res;     
    }

    private boolean isValid(int[] record, int i, int j) {
        for (int k=0; k<i;k++) {
            if (record[k] == j || Math.abs(i-k)== Math.abs(record[k]-j)) {
                return false;
            }
        }
        return true;
    }
}
