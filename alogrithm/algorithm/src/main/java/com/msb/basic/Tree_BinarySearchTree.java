package com.msb.basic;

import com.lintcode.common.TreeNode;

public class Tree_BinarySearchTree {

    class Info {
        boolean isBST;
        public int max;
        public int min;
        public Info(boolean bst, int max, int min) {
            this.isBST = bst;
            this.max = max;
            this.min = min;
        }
    }
    public boolean isBST(TreeNode root) {
        Info result = process(root);
        return result == null? true: result.isBST;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return null;
        }

        Info left = process(node.left);
        Info right = process(node.right);

        int max = node.val;
        int min = node.val;

        if (left != null) {
            max = Math.max(left.max, max);
            min = Math.min(left.min, min);
        }

        if (right != null) {
            min = Math.min(right.min, min);
            max = Math.max(right.max, max);
        }

        boolean isBST = true;
        if (left != null && !left.isBST) {
            isBST = false;
        }

        if (right != null && !right.isBST) {
            isBST = false;
        }

        boolean leftMax = left == null ? true: (left.max < node.val);
        boolean rightMin = right == null ? true: (right.min > node.val);
        if (!leftMax || !rightMin) {
            isBST = false;
        }

        return new Info(isBST, max, min);
    }

}
