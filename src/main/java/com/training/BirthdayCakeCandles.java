package com.training;

public class BirthdayCakeCandles {
    public static void main(String[] args) {
        int[] ar = {4,4,1,3};
        birthdayCakeCandles(ar);
    }
    static int birthdayCakeCandles(int[] ar) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int a :ar ) {
            if(max < a) {
                max = a;
                count = 1;
            } else if(max==a) {
                count++;
            }
        }
        return count;
    }
}
