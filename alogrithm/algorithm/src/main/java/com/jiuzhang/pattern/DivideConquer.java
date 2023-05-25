package com.jiuzhang.pattern;

import com.lintcode.common.TreeNode;

public class DivideConquer {
    class Result {
        public boolean isBalance;
        public int height;
        Result(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }
    
    public Result divideConquer(TreeNode node) {
        if (node == null) {
            return new Result(true, 0);
        }
        Result left = divideConquer(node.left);
        Result right = divideConquer(node.right);
        if (!left.isBalance || !right.isBalance) {
            return new Result(false, 0);
        }

        if (Math.abs(left.height - right.height)>1) {
            return new Result(false, 0);
        }

        int height = Math.max(left.height, right.height)+1;
        return new Result(true, height);
    }
}
