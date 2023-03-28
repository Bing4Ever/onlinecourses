package com.lintcode.daily;

/**
 * https://www.lintcode.com/problem/491/description
 */
public class Code491_PalindromeNumber {
    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        String strNum = String.valueOf(num);
        int start = 0; 
        int end = strNum.length()-1;
        while(start < end) {
            if (strNum.charAt(start)!=strNum.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}
