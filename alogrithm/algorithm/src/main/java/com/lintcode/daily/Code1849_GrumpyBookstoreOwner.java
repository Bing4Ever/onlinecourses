package com.lintcode.daily;

/**
 * <p>https://www.lintcode.com/problem/1849/</p>
 */
public class Code1849_GrumpyBookstoreOwner {
    
    /**
     * @param customers: the number of customers
     * @param grumpy: the owner's temper every day
     * @param x: X days
     * @return: calc the max satisfied customers
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int max = 0;
        for (int i=0; i<customers.length; i++) { 
            if (grumpy[i] == 0) {
                max+=customers[i];
            }
        }

        int left = 0;
        int newSatisfy = 0;
        int maxSatisfy = 0; 
        for (int right = 0; right<customers.length; right++) {
            if (grumpy[right] == 1) {
                newSatisfy+=customers[right];
            }
            if (right-left+1 > x) {
                if (grumpy[left] == 1) {
                    newSatisfy -= customers[left];
                }                
                left++;
            }
            maxSatisfy = Math.max(newSatisfy, maxSatisfy);
        }
        
        return max+maxSatisfy;
    }
}
