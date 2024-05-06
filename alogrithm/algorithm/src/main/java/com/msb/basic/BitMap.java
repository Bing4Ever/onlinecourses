package com.msb.basic;

public class BitMap {
    private long[] bits;

    public BitMap(int max) {
        this.bits = new long[(max + 64) >> 6];
    }

    public void add(int num) {
        // num >> 6 -> num / 64
        // num % 64 -> num & 63
        bits[num >> 64] |= (1L << (num & 63)); 
    }

    public void delete(int num) {
        bits[num >> 64] &= ~(1L << (num & 63));
    }

    public boolean contains(int num) {
        return (bits[num >> 64] & (1 << (num & 63)))!=0;
    }
}
