package com.lintcode.daily;

import java.util.*;

/**
 * <p>https://www.lintcode.com/problem/1001</p>
 */
public class Code1001_AsteroidCollision {
    /**
     * @param asteroids: a list of integers
     * @return: return a list of integers
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }
            while (true) {
                int prev = stack.peek();
                if (prev < 0) {
                    stack.push(asteroids[i]);
                    break;
                }
                if (prev == -asteroids[i]) {
                    stack.pop();
                    break;
                }
                if (prev > -asteroids[i]) {
                    break;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(asteroids[i]);
                    break;
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
    
}
