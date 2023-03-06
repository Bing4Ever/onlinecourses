package com.lintcode.daily;

import java.util.*;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return the original string.
 * You can assume the string has only upper and lower case letters (a-z).
 * <p>https://www.lintcode.com/problem/213</p>
 */
public class Code213_StringCompression {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String originalString) {
        // write your code here
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        while (end < originalString.length()) {
            int count = 0;
            while (end < originalString.length() && originalString.charAt(start)==originalString.charAt(end)) {
                end++;
                count++;
            }
            sb.append(originalString.charAt(start));
            sb.append(String.valueOf(count));
            start = end;
        }
        
        return sb.toString().length() >= originalString.length()? originalString: sb.toString();

    }
}
