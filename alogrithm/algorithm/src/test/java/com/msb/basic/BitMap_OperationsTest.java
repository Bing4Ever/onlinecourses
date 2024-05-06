package com.msb.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BitMap_OperationsTest {
    private BitMap_Operations target;

    @Before
    public void BitMap_OperationsTest() {
        this.target = new BitMap_Operations();
    }

    @Test
    public void testAdd() {
        int result = this.target.add(3, 4);
        assertEquals(7, result);

        int result1 = this.target.add(0, 0);
        assertEquals(0, result1);

        int result2 = this.target.add(39123, 4588);
        assertEquals(39123+4588, result2);
    }

    @Test
    public void testAdd1() {
        int result = this.target.add1(3, 4);
        assertEquals(7, result);

        int result1 = this.target.add1(0, 0);
        assertEquals(0, result1);

        int result2 = this.target.add1(39123, 4588);
        assertEquals(39123+4588, result2);
    }

    @Test
    public void testNeg() {
        int result = this.target.neg(123, 2);
        assertEquals(123-2, result);
    }
}
