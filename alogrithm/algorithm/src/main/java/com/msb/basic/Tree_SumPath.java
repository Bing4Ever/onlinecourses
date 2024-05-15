package com.msb.basic;

import java.util.*;

import com.lintcode.common.TreeNode;

public class Tree_SumPath {
    private boolean isSum = false;

    public boolean sumPath(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, target);
        return isSum;
    }

    private void process(TreeNode node, int preSum, int sum) {
        if (node.left == null && node.right == null) {
            if (node.val + preSum == sum) {
                isSum = true;
            }
            return;
        }

        preSum += node.val;
        if (node.left!=null) {
            process(node.left, preSum, sum);
        }
        
        if (node.right!=null) {
            process(node.right, preSum, sum);
        }
    }

    public List<List<Integer>> pathSum(TreeNode node, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (node == null) {
            return ans;
        }

        process(node, new ArrayList<>(), 0, sum, ans);
        return ans;
    }

    private void process(TreeNode node, List<Integer> path, int preSum, int sum, List<List<Integer>> ans) {
        if (node.left == null && node.right == null) {
            if (node.val + preSum == sum) {
                path.add(node.val); 
                ans.add(copy(path));
                path.remove(node.val);
            }
        }
        path.add(node.val);
        preSum += node.val;
        if (node.left != null) {
            process(node.left, path, preSum, sum, ans);
        }

        if (node.right != null) {
            process(node.right, path, preSum, sum, ans);
        }

        path.remove(path.size()-1);
    }

    private List<Integer> copy(List<Integer> path) {
        List<Integer> ans = new ArrayList<>();
        for (Integer num: path) {
            ans.add(num);
        }
        return ans;
    }
}
