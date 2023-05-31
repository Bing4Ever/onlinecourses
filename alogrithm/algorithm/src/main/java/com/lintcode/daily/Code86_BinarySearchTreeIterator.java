package com.lintcode.daily;

import java.util.Stack;

import com.lintcode.common.TreeNode;

/*
 * https://www.lintcode.com/problem/86/
 */
public class Code86_BinarySearchTreeIterator {
    private Stack<TreeNode> stack = new Stack<>();
    
    public Code86_BinarySearchTreeIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root  = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public TreeNode next() {
        TreeNode cur = stack.peek();
        TreeNode node = cur;
        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
        } else {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return cur;
    }
}
