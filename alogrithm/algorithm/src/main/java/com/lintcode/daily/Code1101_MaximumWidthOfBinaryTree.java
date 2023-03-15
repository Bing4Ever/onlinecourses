package com.lintcode.daily;

import java.util.*;
import java.util.logging.Level;

import com.lintcode.common.TreeNode;

/**
 * Description
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 * The width of a layer of a binary tree is defined as the distance between the nodes at both ends of the layer. Note that the empty node between the nodes at both ends is also counted as the length.
 * <p>https://www.lintcode.com/problem/1101</p>
 */
public class Code1101_MaximumWidthOfBinaryTree { 
    /**
     * @param root: the root
     * @return: the maximum width of the given tree
     */
    public int widthOfBinaryTree(TreeNode root) {
        // Write your code here
        // Write your code here
        int result = Integer.MIN_VALUE;
        LinkedList<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode first = queue.peekFirst();
            TreeNode last = queue.peekLast();
            result = Math.max(result, last.val - first.val +1);
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null) {
                    node.left.val = node.val * 2;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2+1;
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
