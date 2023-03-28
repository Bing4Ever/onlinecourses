package com.lintcode.daily;

/**
 * https://www.lintcode.com/problem/627/description
 */
public class Code627_LongestPalindrome {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        int[] chars = new int[256];
        for (char c: s.toCharArray()) {
            chars[c]++;
        }
        int result = 0;
        boolean hassingle = false;
        for (int i=0; i<256; i++){
            if (chars[i] == 0) {
                continue;
            }
            if (chars[i]%2 == 0) {
                result+=chars[i];
            } else {
                result += chars[i]-1;
                hassingle = true;
            }
        }
        return result+(hassingle?1:0);
    }
}
