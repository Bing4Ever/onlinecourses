package com.msb.basic;

public class BitMap_Operations {

    public int add(int num1, int num2){
        int a = num1 & num2;
        int b = num1 ^ num2;
        if (a == 0) {
            return b;
        }
        return add(a<<1, b);
    }

    public int add1(int num1, int num2){
        int sum = num1;
        while (num2 !=0) {
            sum = num1 ^ num2;
            num2 = (num1 & num2)<<1;
            num1 = sum; 
        }
        return sum;
    }

    /**
     * a - b = a + (~b + 1)
     * @param num1
     * @param num2
     * @return
     */
    public int neg(int num1, int num2) {
        return add(num1, getNeg(num2));
    }

    /**
     * input is 64 and the output is-64
     * @param num
     * @return
     */
    private int getNeg(int num) {
        return add(~num, 1);
    }
}
