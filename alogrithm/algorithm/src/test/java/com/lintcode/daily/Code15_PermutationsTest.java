package com.lintcode.daily;

import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class Code15_PermutationsTest {
    private Code15_Permutations target;
    @Before
    public void setup() {
        this.target = new Code15_Permutations();
    }

    @Test
    public void testPermute() {
        int[] input = {0, 1};
        List<List<Integer>> result = target.permute(input);
        assertTrue(true);
    }
}
