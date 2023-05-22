package com.lintcode.daily;

/**
 * https://www.lintcode.com/problem/8
 */
public class Code8_RotateCharacterArray {
    /**
     * @param s: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] s, int offset) {
        // write your code here
        int num = s.length;
        offset = offset % num;
        reverse(s, 0, num - offset - 1);
        reverse(s, num - offset, num-1); 
        reverse(s, 0, num-1);
        
    }

    private void reverse(char[] s, int start, int end) { 
        while (start<end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
