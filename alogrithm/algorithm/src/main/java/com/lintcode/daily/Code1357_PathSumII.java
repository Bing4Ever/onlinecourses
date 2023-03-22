package com.lintcode.daily;

import java.util.*;

import com.lintcode.common.TreeNode;

/**
 * <p>https://www.lintcode.com/problem/1357</p>
 */
public class Code1357_PathSumII {
    /**
     * @param root: a binary tree
     * @param sum: the sum
     * @return: the scheme
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        processCalculate(root, 0, sum, new ArrayList<Integer>(), result);

        return result;
    }

    private void processCalculate(TreeNode node, int sum, int target, List<Integer> list, List<List<Integer>> result) {
        if (node == null) {
            return ;
        }

        list.add(node.val);
         sum += node.val;
        processCalculate(node.left, sum, target, list, result);
        processCalculate(node.right, sum, target, list, result);
        
        if (sum == target) {
            result.add(new ArrayList<>(list)); 
        }
        list.remove(node.val);
    }
}
