package com.lintcode.daily;

public class Code1870_NumberOfSubstringsWithAllZeroes {
    /**
     * @param str: the string
     * @return: the number of substrings 
     */
    public int stringCount(String str) {
        // Write your code here.
        if (str == null || str.length() == 0) {
            return 0;
        }
        int ans = 0;
        int j = 1;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) != '0') {
                continue;
            }
            while (j<str.length() && str.charAt(j) == '0') {
                j++;
            }
            ans += j-i;
        }
        return ans;
    }
}
