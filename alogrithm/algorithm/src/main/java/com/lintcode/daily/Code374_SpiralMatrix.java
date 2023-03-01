package com.lintcode.daily;

import java.util.*;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>https://www.lintcode.com/problem/374/</p>
 */
public class Code374_SpiralMatrix {
    class Pos {
        int i;
        int j;
        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    /**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here        
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int i=0, j=0;
        Queue<int[]> dir = new LinkedList<>();
        dir.add(new int[]{0,1});
        dir.add(new int[]{1,0});
        dir.add(new int[]{0,-1});
        dir.add(new int[]{-1,0});
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(i, j));
        result.add(matrix[i][j]);
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        visit[i][j] = true;
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            int[] next = dir.poll();
            int newX = pos.j+next[1];
            int newY = pos.i+next[0];
            Pos last = null;
            while (isValid(newX, newY,matrix, visit)) {
                last = new Pos(newY, newX);
                visit[newY][newX] = true;
                result.add(matrix[newY][newX]);
                newX += next[1];
                newY += next[0];
            }
            if (last!=null) {
                queue.add(last);
                dir.add(next);
            }
        }
        return result;
        
    }

    public boolean isValid(int x, int y, int[][] matrix, boolean[][] visit) {
        if (x == matrix[0].length || y == matrix.length || x <0 || y <0 || visit[y][x]) {
            return false;
        }
        return true;
    }
}
