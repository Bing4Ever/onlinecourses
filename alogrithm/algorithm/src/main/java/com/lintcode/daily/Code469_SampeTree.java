package com.lintcode.daily;

import com.lintcode.common.TreeNode;

/**
 * Description
 * Check if two binary trees are identical. Identical means the two binary trees
 * have the same structure and every identical position has the same value.
 * <p>
 * https://www.lintcode.com/problem/469/
 * </p>
 */
public class Code469_SampeTree {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b != null) {
            return false;
        }

        if (a != null && b == null) {
            return false;
        }

        if (a == null) {
            return true;
        }

        if (a.val != b.val) {
            return false;
        }

        boolean left = isIdentical(a.left, b.left);
        if (!left) {
            return false;
        }

        boolean right = isIdentical(a.right, b.right);
        return right;

    }
}


