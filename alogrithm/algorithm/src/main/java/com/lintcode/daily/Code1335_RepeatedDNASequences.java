package com.lintcode.daily;

import java.util.*;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 */
public class Code1335_RepeatedDNASequences {
    /**
     * @param s: a string
     * @return: return List[str]
     *          we will sort your return value in output
     */
    public List<String> findRepeatedDnaSequences(String s) {
        // write your code here
        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i=0; i<=n-10; ++i) {
            String sub = s.substring(i, i+10);
            map.put(sub, map.getOrDefault(sub, 0)+1);
            if (map.get(sub) == 2) {
                result.add(sub);
            }
            
        }
        return result;
    }
}
