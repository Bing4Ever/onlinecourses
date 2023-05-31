package com.lintcode.daily;
import java.util.*;

import com.lintcode.common.UndirectedGraphNode;

public class Code137_CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        List<UndirectedGraphNode> nodes = findAllNodes(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode n: nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }

        for (UndirectedGraphNode n: nodes) {
            for (UndirectedGraphNode neighbor: n.neighbors) {
                UndirectedGraphNode newNode = map.get(n);
                newNode.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);

    }

    private List<UndirectedGraphNode> findAllNodes(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> visit = new HashSet();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visit.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode next = queue.poll();
            for (UndirectedGraphNode neighbor: next.neighbors) {
                if (!visit.contains(neighbor)) {
                    queue.offer(neighbor);
                    visit.add(neighbor);
                }
            }
        }
        return new LinkedList<>(visit);

    }
}
