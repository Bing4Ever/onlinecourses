package com.jiuzhang.pattern;

import java.nio.file.attribute.GroupPrincipal;
import java.util.*;

public class TSP {
    class Result {
        int minCost;
        public Result() {
            minCost = Integer.MAX_VALUE;
        }

    }
    public int minCost(int n, int[][] road) {
        int[][] graph = constructGraph(road, n);
        Set<Integer> visit = new HashSet<>();
        visit.add(1);
        Result result = new Result();
        dfs(1, n, visit, 0, graph, result);
        return result.minCost;
    }

    private void dfs(int city, int n, Set<Integer> visit, int cost, int[][] graph, Result result) {
        if (visit.size() == n) {
            result.minCost = Math.min(cost, result.minCost);
            return;
        }

        for (int i=0; i< graph[city].length; i++){
            if (visit.contains(i)) {
                continue;
            }
            visit.add(i);
            dfs(i, n, visit, cost+graph[city][i], graph, result);
            visit.remove(visit.size()-1);
        }

    }


    private int[][] constructGraph(int[][] road, int n) {
        int[][] graph = new int[n+1][n+1];
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<n+1; j++) {
                graph[i][j] = Integer.MAX_VALUE >> 4;
            }
        }

        for (int i=0; i<road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            graph[a][b] = Math.min(graph[a][b], c);
            graph[b][a] = Math.min(graph[b][a], c);

        }
        return graph;
    }
}
