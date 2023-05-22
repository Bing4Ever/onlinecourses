package com.lintcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/147
 */
public class Code147_NarcissisticNumber {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        int end = 9;
        int start = n == 1?0: (int)Math.pow(10, n-1);
        for (int i=1; i<n; i++){
            end = end*10+9; 
        }
        List<Integer> result = new ArrayList<>();
        for (int i=start; i<=end; i++) {
            if (isValid(i,n)) {
                result.add(i,n);
            }
        }
        return result;

    }

    private boolean isValid(int num, int n){
        int result = 0;
        for (char c: String.valueOf(num).toCharArray()) {
            int i = Integer.valueOf(String.valueOf(c));
            result += (int)Math.pow(i, n);
        }
        return result == num;
    }
}
