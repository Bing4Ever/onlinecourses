package com.lintcode.daily;

/**
 * Given a string with B*A*C*D* pattern, * means the preceding character can appear 0 or multiple times in the string. Count the number of 'A'.
 * <p>https://www.lintcode.com/problem/1578/</p>
 */
public class Code1578_NumberOfA {
    /**
     * @param s: the given string
     * @return: the number of A
     */
    public int countA(String s) {
        // Write your code here
        int as = findStart(s);
        if (s.charAt(as)!='A') {
            return 0;
        }

        int es = findEnd(s);
        if (s.charAt(es)!= 'A') {
            return 0;
        }
        int count = es - as +1;
        return count;
    }

    private int findStart(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start+1 < end) {
            int mid = start + (end - start)/2;
            if (s.charAt(mid) == 'A' || s.charAt(mid) == 'C' || s.charAt(mid) == 'D') {
                end = mid;
            } else if (s.charAt(mid) == 'B') {
                start = mid+1;
            }
        }
        return s.charAt(start) == 'A'?start:end;
    }

    private int findEnd(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start+1 < end) {
            int mid = start + (end - start)/2;
            if (s.charAt(mid) == 'C' || s.charAt(mid) == 'D') {
                end = mid-1;
            } else if (s.charAt(mid) == 'A' || s.charAt(mid) == 'B') {
                start = mid;
            }
        }
        return s.charAt(end) == 'A'?end:start;
    }
}
