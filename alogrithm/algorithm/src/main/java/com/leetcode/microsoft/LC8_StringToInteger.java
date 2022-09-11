package com.leetcode.microsoft;

public class LC8_StringToInteger {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int sig = 1;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == ' ') {
            pos++;
        }
        for (int start = pos; start < s.length(); start++) {
            if (start == pos && (s.charAt(start) == '+' || s.charAt(start) == '-'))  {
                sig = s.charAt(start) == '+'? 1: -1;
            } else if (!Character.isDigit(s.charAt(start))) {
                return sig * result;
            } else if (sig == 1 && LargerThanMAX(result, s.charAt(start))) {
                return Integer.MAX_VALUE;
            } else if (sig == -1 && LessThanMin(result * sig, s.charAt(start))) {
                return Integer.MIN_VALUE;
            } else {
                result = (result * 10) + Integer.valueOf(String.valueOf(s.charAt(start)));
            }
        }
        return result * sig;
    }

    private boolean LessThanMin(int result, char c) {
        if (result < Integer.MIN_VALUE/10) {
            return true;
        }
        if (result > Integer.MIN_VALUE/10) {
            return false;
        }
        if (Integer.valueOf(String.valueOf(c)) > 8) {
            return true;
        }
        return false;
    }

    private boolean LargerThanMAX(int result, char c) {
        if (result < Integer.MAX_VALUE/10) {
            return false;
        }
        if (result > Integer.MAX_VALUE/10) {
            return true;
        }
        if (Integer.valueOf(String.valueOf(c)) > 7) {
            return true;
        }
        return false;
    }
}
