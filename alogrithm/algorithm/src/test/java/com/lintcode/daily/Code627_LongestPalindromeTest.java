package com.lintcode.daily;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code627_LongestPalindromeTest {
    private Code627_LongestPalindrome target;

    @Before
    public void setup() {
        this.target = new Code627_LongestPalindrome();
    }

    @Test
    public void testLongestPalindrome() {
        String input = "NTrQdQGgwtxqRTSBOitAXUkwGLgUHtQOmYMwZlUxqZysKpZxRoehgirdMUgy";
        int result = this.target.longestPalindrome(input);
        assertEquals(39, result);
    }
}
