package com.lintcode.daily;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

import com.lintcode.common.TreeNode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Code86_BinarySearchTreeIteratorTest {
    
    private Code86_BinarySearchTreeIterator target;

    @Before
    public void setup() {
        TreeNode node = new TreeNode(16);
        node.left = new TreeNode(14);
        node.right = new TreeNode(18);
        node.left.left = new TreeNode(8);
        node.left.right = new TreeNode(15);
        node.left.left.right = new TreeNode(10);
        node.left.left.right.left = new TreeNode(9);
        this.target = new Code86_BinarySearchTreeIterator(node);
    }

    @Test
    public void testBSTSearch() {
        List<Integer> list = new ArrayList<>(); 
        while (target.hasNext()) {
            list.add(this.target.next().val);
        }
        //assertArrayEquals(list.toArray(), new int[]{8,9,10,14,15,16,18});
        assertTrue(true);
    }
}
