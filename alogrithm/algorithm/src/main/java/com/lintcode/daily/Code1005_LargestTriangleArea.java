package com.lintcode.daily;

/**
 * <p>https://www.lintcode.com/problem/1005</p>
 */
public class Code1005_LargestTriangleArea {
    /**
     * @param points: List[List[int]]
     * @return: return a double
     */
    public double largestTriangleArea(int[][] points) {
        // write your code here
        double ans = 0.0;
        for (int i=0; i<points.length-2; i++) {
            for (int j=i+1; j< points.length-1; j++ ) {
                for (int k = j+1; k<points.length; k++) {
                    ans = Math.max(ans, calculate(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    private double calculate(int[] a, int[] b, int[] c) {
        return 0.5 * Math.abs(a[0]*b[1] + b[0]*c[1]+ c[0]*a[1] - a[1]*b[0]-b[1]*c[0]-c[1]*a[0]);
    }

}
