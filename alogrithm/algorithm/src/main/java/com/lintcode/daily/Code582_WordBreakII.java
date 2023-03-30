package com.lintcode.daily;

import java.util.*;

public class Code582_WordBreakII {
    Map<Integer, List<String>> ans = new HashMap<Integer, List<String>>();
    Set<String> wordSet;
    void backtrack(String s, int index) {
        if (!ans.containsKey(index)) {
            if(index == s.length()) {
                ans.put(index, new ArrayList<>());
                return;
            }
            ans.put(index, new ArrayList<>());
            for (int i = index + 1; i <= s.length(); ++i) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    backtrack(s, i);
                    if (ans.get(i).isEmpty() && i == s.length()) {
                        ans.get(index).add(word);
                    } else {
                        for (String succ: ans.get(i)) {
                            ans.get(index).add(word + " " + succ);
                        }
                    }
                    
                }
            }
        }
    }
    public List<String> wordBreak(String s, Set<String> wordDict) {
        wordSet = wordDict;
        backtrack(s, 0);
        return ans.get(0);
    }
}
