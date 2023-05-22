package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code32_MinimumWindowSubstringTest {
    private Code32_MinimumWindowSubstring target;
    @Before
    public void setup(){
        this.target = new Code32_MinimumWindowSubstring();
    }

    @Test
    public void testMinWindow() {
        String source = "aaaaaaaaaaaabbbbbcdd";
        String target = "abcdd";
        String ret = this.target.minWindow(source, target);
        assertEquals("abbbbbcdd", ret);
    }
}
