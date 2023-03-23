package com.lintcode.daily;

import java.util.*;

/**
 * <p>https://www.lintcode.com/problem/693/</p>
 */
public class Code693_RemoveDigits {
    /**
     * @param num: a number
     * @param k: the k digits
     * @return: the smallest number
     */
    public String removeKdigits(String num, int k) {
        // write your code here.
        LinkedList<Character> stack = new LinkedList<>();
        Stack<Character> s = new Stack<>();
        for (char ch: num.toCharArray()) {
            while (stack.size() > 0 && k>0 && stack.peekLast() > ch) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(ch);
        }

        for (int i=0; i<k; i++) {
            stack.removeLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (char digit: stack) {
            if (isZero && digit == '0') {
                continue;
            }
            isZero = false;
            sb.append(digit);
        }

        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
