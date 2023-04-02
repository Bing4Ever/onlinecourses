package com.lintcode.daily;

import java.util.*;

/**
 * <p>https://www.lintcode.com/problem/1563</p>
 */
public class Code1563_ShortestPathToTheDestination {
    /**
     * @param targetMap: 
     * @return: nothing
     */
    public int shortestPath(int[][] targetMap) {
        // Write your code here
        Queue<int[]> queue = new LinkedList<>();
        int[] root = {0,0};
        queue.offer(root);
        int[] x = {1,0,0,-1};
        int[] y = {0,-1,1, 0};
        int[] target = {0,0};
        for (int i=0; i<targetMap.length; i++) {
            for (int j=0; j<targetMap[0].length; j++) {
                if (targetMap[i][j] == 1) {
                    targetMap[i][j] = Integer.MIN_VALUE;
                }
                if (targetMap[i][j] == 2) {
                    target =new int[] {i, j};
                    targetMap[i][j] = 0;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i=0; i<4; i++) {
                int newX = cur[1] + x[i];
                int newY = cur[0] + y[i];
                if (isValid(newX, newY, targetMap)) {
                    int step = targetMap[cur[0]][cur[1]]+1;
                    if (targetMap[newY][newX]==0 || step<=targetMap[newY][newX]) {
                        targetMap[newY][newX] = step;
                        queue.offer(new int[]{newY, newX});
                    }
                }
            }
        }

        return targetMap[target[0]][target[1]] == 0?-1:targetMap[target[0]][target[1]];
    }

    private boolean isValid(int x, int y, int[][] targtMap) {
        if (x<0 || x==targtMap[0].length || y<0 || y== targtMap.length || targtMap[y][x] == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }
}
