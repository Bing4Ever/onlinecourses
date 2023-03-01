package com.lintcode.daily;

import java.util.*;
import java.util.Map.Entry;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>https://www.lintcode.com/problem/1281/</p>
 */
public class Code1281_TopKFrequentElements {
    /**
     * @param nums: the given array
     * @param k: the given k
     * @return: the k most frequent elements
     *          we will sort your return value in output
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Entry> queue = new PriorityQueue<>((a,b)->((int)a.getValue() - (int)b.getValue()));
        for (Entry entry : map.entrySet()){
            queue.add(entry);
        }

        List<Integer> result = new ArrayList<>();
        for (int i=0; i<k; i++) {
            result.add((int)queue.poll().getKey());
        }
        return result;
    }
}
