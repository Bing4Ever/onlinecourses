package com.msb.basic;

import com.lintcode.common.TrieTreeNode;

public class TrieTree {

    private TrieTreeNode root;

    public TrieTree() {
        root = new TrieTreeNode();
    }
    public void insert(String word) {
        if (word == null) {
            return;
        }

        char[] chars = word.toCharArray();
        TrieTreeNode node = root;
        node.pass++;
        int path = 0;
        for (int i=0; i<chars.length; i++) {
            path = chars[i] - 'a';
            if (node.nexts[path] == null){
                node.nexts[path] = new TrieTreeNode();
            }
            node = node.nexts[path];
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word) !=0) {
            char[] chars = word.toCharArray();
            TrieTreeNode node = root;
            node.pass--;
            int path =0;
            for (int i=0; i<chars.length; i++) {
                path = chars[i] - 'a';
                if (--node.nexts[path].pass == 0) {
                    node.nexts[path] = null;
                    return;
                }
                node = node.nexts[path];
            }
            node.end--;
        }
    }
    
    public int search(String word){
        if (word == null) {
            return -1;
        }
        char[] chars = word.toCharArray();
        TrieTreeNode node = root;
        int index = 0;
        for (int i=0; i< chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] ==null) {
                return -1;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }
        char[] chars = pre.toCharArray();
        TrieTreeNode node = root;
        int index = 0;
        for (int i=0; i<chars.length; i++) {
            index = chars[i]-'a';
            if (node.nexts[index]==null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }
}
