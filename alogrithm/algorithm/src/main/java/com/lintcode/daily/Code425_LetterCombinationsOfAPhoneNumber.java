package com.lintcode.daily;

import java.util.*;

/**
 * Given a digit string excluded 0 and 1, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class Code425_LetterCombinationsOfAPhoneNumber {

    
    /**
     * @param digits: A digital string
     * @return: all possible letter combinations
     *          we will sort your return value in output
     */
    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        List<String> result = new ArrayList<>();
        process(digits, 0, result, map, "");
        return result;
    }

    private void process(String digits, int index, List<String> result, Map<String,String> map, String str) {
        if (index == digits.length()) {
            result.add(str);
            return;
        }

        String cur = String.valueOf(digits.charAt(index));
        String chars = map.get(cur);
        for (int i=0; i<chars.length(); i++){
            process(digits, index+1, result, map, str+String.valueOf(chars.charAt(i)));
        }
    } 
}
