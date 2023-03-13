package com.lintcode.daily;

import java.util.*;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * Return true if and only if it is possible to split everyone into two groups in this way.Otherwise, return false.
 * <p>https://www.lintcode.com/problem/1596/</p>
 */
public class Code1596_PossibleBipartition {
    private List<Integer>[] adj;
    private Map<Integer, Integer> color;
    
    /**
     * @param n:  sum of the set
     * @param dislikes: dislikes peoples
     * @return:  if it is possible to split everyone into two groups in this way
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Write your code here.
        adj = new ArrayList[n+1];
        for (int i=1; i<= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge:dislikes) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        color = new HashMap<>();
        for (int i=1;i<=n ;i++) {
            if (!color.containsKey(i) && !dfs(i,0)) 
                return false;
        }
        return true;
    }

    private boolean dfs(int node, int c){
        if (color.containsKey(node)) {
            return color.get(node) == c;
        }

        color.put(node, c);

        for (int nei: adj[node]) {
            if (!dfs(nei, c^1))
                return false;
        }
        return true;
    }
}   
