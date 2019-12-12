package com.training;

public class ReverseArray {

    public static void main(String[] args) {
        int[] a = {};
        int[] output = reverseArray(a);
    }

    private static int[] reverseArray(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
        return a;
    }
}
