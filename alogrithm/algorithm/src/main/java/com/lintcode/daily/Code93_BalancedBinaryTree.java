package com.lintcode.daily;

import com.lintcode.common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Wechat reply 【Two Sigma】 get the latest requent Interview qu
 */
public class Code93_BalancedBinaryTree {
    class BstResult {
        int height;
        boolean isBalanced;
        public BstResult(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }

        BstResult result = isBalancedTree(root);
        return result.isBalanced;
    }

    private BstResult isBalancedTree(TreeNode node){
        if (node == null) {
            return new BstResult(0, true);
        }

        BstResult left = isBalancedTree(node.left);
        BstResult right = isBalancedTree(node.right);

        if (!left.isBalanced) {
            return new BstResult(0, false);
        }

        if (!right.isBalanced) {
            return new BstResult(0, false);
        }

        if (Math.abs(left.height - right.height)>1) {
            return new BstResult(0, false);
        }

        return new BstResult(Math.max(left.height, right.height)+1, true);
    }
}
