package com.msb.basic;

import com.lintcode.common.TreeNode;

public class Tree_BalancedBinaryTree {

    public class Info {
        int height;
        boolean isBalance;
        public Info(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public boolean isBalance(TreeNode node) {
        Info result = process(node);
        return result.isBalance;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, true);
        }

        Info left = process(node.left);
        Info right = process(node.right);

        int height = Math.max(left.height, right.height)+1;
        boolean isBalance = left.isBalance && right.isBalance && Math.abs(left.height - right.height) <2;
        return new Info(height, isBalance);
    }
}
