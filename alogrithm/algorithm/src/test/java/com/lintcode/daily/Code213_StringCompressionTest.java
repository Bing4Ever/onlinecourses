package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code213_StringCompressionTest {
    private Code213_StringCompression target;

    @Before
    public void setup() {
        this.target = new Code213_StringCompression();
    }

    @Test
    public void testCompress() {
        String str = "aabcccccaaa";
        String result = target.compress(str);
        assertEquals("a2b1c5a3", result);
    }
}
