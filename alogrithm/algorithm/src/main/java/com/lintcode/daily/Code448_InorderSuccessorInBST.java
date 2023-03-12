package com.lintcode.daily;

import com.lintcode.common.TreeNode;

/**
 * <p>https://www.lintcode.com/problem/448/description</p>
 */
public class Code448_InorderSuccessorInBST {
    class Result {
        boolean hasNode;
        TreeNode target;
        public Result(boolean hasNode, TreeNode parent) {
            this.hasNode = hasNode;
            this.target = parent;
        }
    }
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
       TreeNode cand = null;
       while (root != null) {
        if (p.val >= root.val) {
            root = root.right;
        } else {
            cand = root;
            root = root.left;
        }
       }
       return cand;
    } 
}
