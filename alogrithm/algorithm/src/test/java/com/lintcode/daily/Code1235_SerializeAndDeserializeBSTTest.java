package com.lintcode.daily;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.lintcode.common.TreeNode;

import org.junit.Before;
import org.junit.Test;

public class Code1235_SerializeAndDeserializeBSTTest {
    private Code1235_SerializeAndDeserializeBST target;

    @Before
    public void setup() {
        this.target = new Code1235_SerializeAndDeserializeBST();
    }

    @Test
    public void testDeserialize() {
        String input = "{2,1,3}";
        TreeNode root = target.deserialize(input);
        assertEquals(root.val, 2);
        assertEquals(root.left.val, 1);
        assertEquals(root.right.val, 3);
    }

    @Test
    public void testSerialize() {

    }
}
