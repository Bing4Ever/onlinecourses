package com.msb.basic;

import java.util.*;

import com.lintcode.common.TreeNode;

/**
 * Build the tree according to the pre traverse and inorder traverse
 */
public class Tree_LevelOrderTraverse {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curAns = new LinkedList<>();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left!=null) {
                    queue.offer(cur.left);
                }
                if (cur.right!=null) {
                    queue.offer(cur.right);
                }
                curAns.add(cur.val);
            }
            ans.add(0, curAns);
        }
        return ans;

    }
}
