package com.lintcode.daily;

import java.util.*;

/**
 * Description
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * get(key) Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1
 * set(key, value) Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * Finally, you need to return the data from each get.
 * <p>https://www.lintcode.com/problem/134/</p>
 */
public class Code134_LRUCache {
    class LinkNode {
        int val;
        int key;
        LinkNode next;
        LinkNode pre;
        public LinkNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    private int capacity;
    private LinkNode head;
    private LinkNode tail;
    private HashMap<Integer, LinkNode> map;

    /*
    * @param capacity: An integer
    */
    public Code134_LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        head = new LinkNode(0,0);
        tail = new LinkNode(0,0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(capacity);
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            moveToHead(node);
            node.val = value;
            map.put(key, node);
        } else {
            LinkNode node = new LinkNode(key, value);
            setToHead(node);
            map.put(key,node);
        }
        
        if (map.size()>capacity) {
            LinkNode last = tail.pre;
            removeNode(last);
            map.remove(last.key);
        }
    }

    private void moveToHead(LinkNode node){
        LinkNode last = node.pre;
        LinkNode next = node.next;
        last.next = node.next;
        next.pre = last;
        setToHead(node);
    }

    private void setToHead(LinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(LinkNode node) {
        LinkNode pre = node.pre;
        LinkNode next = node.next;
        pre.next = next;
        next.pre = pre;
        node.next = null;
        node.pre = null;
    }
}
