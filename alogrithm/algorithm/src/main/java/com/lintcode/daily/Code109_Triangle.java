package com.lintcode.daily;

import java.util.*;

/**
 * https://www.lintcode.com/problem/109/
 */
public class Code109_Triangle {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int result = traverse(triangle, 0, 0, new HashMap<Integer, Integer>());
        return result;
    }

    private int traverse(int[][] triangle, int x, int y, Map<Integer, Integer> memo) {
        if (x == triangle.length) {
            return 0;
        } 

        int hashCode = x * triangle.length + y;
        if (memo.containsKey(hashCode)) {
            return memo.get(hashCode);
        } 

        
        int left = traverse(triangle, x+1, y,memo);
        int right = traverse(triangle, x+1, y+1, memo);
        memo.put(hashCode, Math.min(left, right) + triangle[x][y]);
        return memo.get(hashCode);
    }
}
