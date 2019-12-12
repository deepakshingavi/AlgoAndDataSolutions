package com.training;

public class MinMaxSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        miniMaxSum(arr);
    }

    static void miniMaxSum(int[] arr) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long finalSum = 0;
        for (int a :arr ) {
            finalSum+=a;
            if(min > a) {
                min= a;
            }
            if(max < a) {
                max = a;
            }
        }
        System.out.print(finalSum-max+ " " );
        System.out.print(finalSum-min);
    }
}
