package com.leetcode.microsoft;

import java.util.*;

public class LC151_ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] arr = SplitStr(s);
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            while (start < end && arr[start].equals("")) {
                start++;
            }
            while (start < end && arr[end].equals("")) {
                end --;
            }
            if (start < end ){
                String tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }

        return String.join(" ", arr).trim();
    }

    public String[] SplitStr(String str) {
        List<String> result = new ArrayList<>();
        String[] arr = str.split(" ");
        for (String word : arr) {
            if (!word.equals("")) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
}
