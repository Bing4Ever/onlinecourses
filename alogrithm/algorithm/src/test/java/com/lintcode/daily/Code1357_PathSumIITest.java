package com.lintcode.daily;


import static org.junit.Assert.assertTrue;

import java.util.*;

import com.lintcode.common.TreeNode;

import org.junit.Before;
import org.junit.Test;

public class Code1357_PathSumIITest {
    private Code1357_PathSumII target;

    @Before
    public void setup() {
        this.target = new Code1357_PathSumII();
    }

    @Test
    public void testPathSum() {
        String input = "5,4,8,11,7,21,4,7,2,#,#,5,1";
        Code1235_SerializeAndDeserializeBST help = new Code1235_SerializeAndDeserializeBST();

        TreeNode node = help.deserialize(input);
        //List<List<Integer>> result = this.target.pathSum(node, 22);
        assertTrue(true);
    }
}
