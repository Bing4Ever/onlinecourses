package com.lintcode.daily;

import com.lintcode.common.TreeNode;

/**
 * <p>https://www.lintcode.com/problem/1317/</p>
 */
public class Code1317_CountCompleteTreeNodes {
    /**
     * @param root: root of complete binary tree
     * @return: the number of nodes
     */
    public int countNodes(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);
        return count;
        
    }
    
}
