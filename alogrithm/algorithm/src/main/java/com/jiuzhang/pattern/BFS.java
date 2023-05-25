package com.jiuzhang.pattern;

import java.util.*;

import com.lintcode.common.TreeNode;

public class BFS {
    public List<List<Integer>> levelOrder_SingleQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> levelOrder_DoubleQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> next_queue = new ArrayList<>();
            result.add(toIntegerList(queue));
            for (TreeNode node: queue) {
                if (node.left != null) {
                    next_queue.add(node.left);
                }
                if (node.right != null) {
                    next_queue.add(node.right);
                }
            }
            queue = next_queue;
        }
        return result;
    }

    private List<Integer> toIntegerList(List<TreeNode> queue) {
        List<Integer> result = new ArrayList<>();
        for (TreeNode node: queue) {
            result.add(node.val);
        }
        return result;
    }

    public List<List<Integer>> levelOrder_DummyNode(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (level.size() == 0) {
                    break;
                }
                result.add(level);
                level = new ArrayList<>();
                queue.offer(null);
                continue;
            }

            level.add(node.val);
            if (node.left!= null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }
}
