package com.lintcode.daily;

import java.util.*;

/**
 * <p>https://www.lintcode.com/problem/787/</p>
 */
public class Code787_TheMaze {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][] visit = new boolean[maze.length][maze[0].length];
        int[] x = {1, 0, 0, -1};
        int[] y = {0, 1, -1, 0};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }
            for (int i=0; i<4; i++) {
                int newX = cur[0]+x[i];
                int newY = cur[1]+y[i];                
                while (isValid(newX, newY, maze)) {
                    newX += x[i];
                    newY += y[i];
                    
                }
                if (!visit[newX - x[i]][newY - y[i]]) {
                    queue.add(new int[] {newX - x[i], newY - y[i]});
                    visit[newX - x[i]][newY - y[i]] = true;
                }           
            }
        }
        return false;

    }

    private boolean isValid(int x, int y, int[][] maze) {
        if (x <0 || x==maze.length || y<0 || y==maze[0].length ||  maze[x][y] == 1) {
            return false;
        }
        return true;
    }
    
}
