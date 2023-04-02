package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code1849_GrumpyBookstoreOwnerTest {
    private Code1849_GrumpyBookstoreOwner target;

    @Before
    public void setup() {
        this.target = new Code1849_GrumpyBookstoreOwner();
    }

    @Test
    public void testMaxSatisfied() {
        int[] cx = {1,0,1,2,1,1,7,5};
        int[] gr = {0,1,0,1,0,1,0,1};
        int x = 3;
        int result = this.target.maxSatisfied(cx, gr, x);
        assertEquals(result, 16);
    }
}
