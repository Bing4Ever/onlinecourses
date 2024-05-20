package com.lintcode.common;

public class TrieTreeNode {
    public int pass;
    public int end;
    public TrieTreeNode[] nexts;

    public TrieTreeNode() {
        pass = 0;
        end = 0;
        nexts = new TrieTreeNode[26];
    }
}
