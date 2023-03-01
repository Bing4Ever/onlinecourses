package com.lintcode.daily;

import java.util.*;

import com.lintcode.common.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).)
 * <p>https://www.lintcode.com/problem/69/</p>
 */
public class Code69_BinaryTreeLevelOrderTraversal {
    
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);        
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<length; i++) {
                TreeNode node = queue.poll();      
                list.add(node.val);
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
