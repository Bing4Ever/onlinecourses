package com.lintcode.daily;

import java.util.*;

/**
 * <p>https://www.lintcode.com/problem/788/</p>
 */
public class Code788_TheMazeII {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        for (int i=0;i<maze.length;i++) {
            for (int j=0;j<maze[0].length;j++) {
                if (maze[i][j] != 1) {
                    maze[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        maze[start[0]][start[1]] = 0;
        boolean[][] visit = new boolean[maze.length][maze[0].length];
        int[] x = {1,0,0,-1};
        int[] y = {0,1,-1,0};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i=0; i<4; i++) {
                int newX = cur[0] +x[i];
                int newY = cur[1] + y[i];
                int step = 0;
                while (isValid(newX, newY, maze)) {
                    newX += x[i];
                    newY += y[i];
                    step++;
                    
                }
                if (!visit[newX-x[i]][newY-y[i]]) {
                    maze[newX][newY] = Math.min(maze[newX][newY],maze[cur[0]][cur[1]]+step);
                    queue.offer(new int[]{newX-x[i], newY-y[i]});
                    visit[newX-x[i]][newY-y[i]] = true;
                }
            }

        }

        return maze[destination[0]][destination[1]] == Integer.MAX_VALUE?-1: maze[destination[0]][destination[1]];
    }

    private boolean isValid(int x, int y, int[][] maze) {
        if (x<0 || x== maze.length || y<0 || y == maze[0].length || maze[x][y] == 1) {
            return false;
        }
        return true;
    }
}
