package com.lintcode.daily;

import java.util.*;

/*
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open '(' and closing parentheses ')', the plus '+' or minus sign '-', non-negative integers and empty spaces ' '.
 */
public class Code978_BasicCalculator {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = 10 * number + (c - '0');
            } else if (c == '+') {
                result += sign *number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign *number;
                sign = -1;
                number = 0;
                
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign *number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (number != 0) {
            result += sign *number;
        }
        return result;
    }
}
