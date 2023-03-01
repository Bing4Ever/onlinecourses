package com.lintcode.daily;

import java.util.*;
import java.util.Map.Entry;

/**
 * Given a list of words and an integer k, return the top k frequent words in the list.
 * <p>https://www.lintcode.com/problem/471</p>
 */
public class Code471_TopKFrequentWords {
    
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word,0)+1);
        }
 
        PriorityQueue<String[]> queue = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int result= Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
                if (result == 0) {
                    return o1[0].compareTo(o2[0]);
                }
                return result;
            }
            
        });

        for (Entry entry : map.entrySet()) {
            queue.add(new String[] {entry.getKey().toString(), entry.getValue().toString()});
        } 

        String[] result = new String[queue.size()>k?k:queue.size()];
        int i = 0;
        while (!queue.isEmpty() && i < k) {
            result[i++] = queue.poll()[0];
        }
        return result;
    }
}
