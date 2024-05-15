package com.msb.basic;

import com.lintcode.common.TreeNode;

public class Tree_Compare {
    public boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null ^ q == null) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }

        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
