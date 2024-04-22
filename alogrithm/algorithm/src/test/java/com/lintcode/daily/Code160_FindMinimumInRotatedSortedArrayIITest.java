package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code160_FindMinimumInRotatedSortedArrayIITest {
    private Code160_FindMinimumInRotatedSortedArrayII target;

    @Before
    public void init() {
        this.target = new Code160_FindMinimumInRotatedSortedArrayII();
    }

    @Test
    public void testFindMin() {
        int[] nums = {6,7,7,7,7,9,1,2,3,4,5,};
        int result = target.findMin(nums);
        
        assertEquals(1, result);
    }
}
