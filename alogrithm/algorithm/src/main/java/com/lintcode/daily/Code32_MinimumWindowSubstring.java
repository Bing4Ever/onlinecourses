package com.lintcode.daily;
/**
 * <p>https://www.lintcode.com/problem/32</p>
 */
public class Code32_MinimumWindowSubstring {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code here
        int length = target.length();
        int[] chars = new int[256];
        for (char c: target.toCharArray()) {
            chars[c]++;
        }

        int left = -1;
        int start = 0;
        int end = 0;
        int max = Integer.MAX_VALUE;
        int right = -1;
        for (; right<source.length(); right++) {
            
            if (chars[source.charAt(right)]>0) {                
                length--;
            }
            chars[right]--;
            if (length==0) {
                if (right - left +1 < max) {
                    start = left;
                    end = right;
                    max = right-left+1;
                }
                chars[left]++;
                left++;
                length++;
                while (left<right && chars[left]<0){
                    left++;
                }
            }
        }
        return max == Integer.MAX_VALUE?"":source.substring(start, end+1);
    }
}
