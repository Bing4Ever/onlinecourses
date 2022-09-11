package com.leetcode.microsoft;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LC151_ReverseWordsInAStringTest {
    private LC151_ReverseWordsInAString target;

    @Before
    public void setup(){
        this.target = new LC151_ReverseWordsInAString();
    }

    @Test
    public void testReverseWords() {
        String str = "a good   example";
        String actual = this.target.reverseWords(str);
        String expected = "example good a";
        assertEquals(expected, actual);
    }
}
