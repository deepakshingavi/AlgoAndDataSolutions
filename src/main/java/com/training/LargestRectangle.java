package com.training;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {

    public static void main(String[] args) {
        int[] h = {1,2,3,4,5};
        System.out.println(largestRectangle(h));
    }

    static long largestRectangle(int[] h) {
        Stack<int[]> s = new Stack<>(); // Create stack of span = [x0, x1]
        int n = h.length;
        h = Arrays.copyOf(h, n+1); // Append a sentinel to array h
        int x1;
        int maximum = 0;
        for(int x0 = 1; x0 <= n; x0++) {
            for(x1 = x0; !s.isEmpty() && h[s.peek()[0]] >= h[x0]; ) {
                int[] x = s.pop();
                x1 = x[1];
                maximum = Math.max(maximum, h[x[0]] * (x0 - x1));
            }
            s.push(new int[]{x0, x1});
        }
        return maximum;
    }
}
