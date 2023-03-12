package com.lintcode.daily;

import java.util.*;

/*
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a Gate, that room should remain filled with INF
 * <p>https://www.lintcode.com/problem/663/</p>
 */
public class Code663_WallsAndGates {
    private int[] x = new int[] {-1, 0, 0, 1};
    private int[] y = new int[] {0, 1, -1, 0};
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int d=0; d<4; d++) {
                int newX = pos[1]+x[d];
                int newY = pos[0]+y[d];
                if (isValid(newX, newY, rooms)) {
                    rooms[newY][newX] =  rooms[pos[0]][pos[1]] + 1;
                    queue.offer(new int[] {newY, newX});
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] rooms) {
        return !(x<0 || y<0 || x==rooms[0].length || y == rooms.length || rooms[y][x] ==0 || rooms[y][x] ==-1 || rooms[y][x] != Integer.MAX_VALUE);
    }
}
