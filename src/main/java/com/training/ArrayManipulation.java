package com.training;

import java.util.Arrays;

public class ArrayManipulation {
    public static void main(String[] args) {
        int[][] queries = {{1,5,3},{4,8,7},{6,9,1}};
        int n = 10;
        long counter = System.currentTimeMillis();
        System.out.println(arrayManipulationOnline(n, queries));
        System.out.println(counter - System.currentTimeMillis());

        counter = System.currentTimeMillis();
        System.out.println(arrayManipulationStream(n, queries));
        System.out.println(counter - System.currentTimeMillis());
    }

    private static long arrayManipulation(int n, int[][] queries) {
        long ans = Long.MIN_VALUE;
        long[] arr = new long[n+1];
//        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j < queries.length; j++) {
                int [] tempArr = queries[j];
                arr[tempArr[0]] = arr[tempArr[0]] + tempArr[2];
                arr[tempArr[1]] = arr[tempArr[1]] + tempArr[2];
                ans = Math.max(Math.max(arr[tempArr[0]],arr[tempArr[1]]),ans);
//                if(tempArr[0] <= i && i <= tempArr[1]) {
//                    arr[i] = arr[i] + tempArr[2];
//                    if(ans < arr[i]) {
//                        ans = arr[i];
//                    }
//                }
            }
//        }
        return ans;
    }

    private static long arrayManipulationStream(int n, int[][] queries) {
        long ans = Long.MIN_VALUE;
        long[] arr = new long[n+1];
        for (int i = 0; i <= n ; i++) {
            for (int[] tempArr : queries) {
                if (tempArr[0] <= i && i <= tempArr[1]) {
                    arr[i] = arr[i] + tempArr[2];
                    if (ans < arr[i]) {
                        ans = arr[i];
                    }
                }
            }
        }
        return ans;
    }

    private static long arrayManipulationOnline(int n, int[][] queries) {
        long ans = Long.MIN_VALUE;
        long[] arr = new long[n];
        for(int i=0;i<queries.length;i++){
            int [] tempArr = queries[i];
            int lower=tempArr[0];
            int upper=tempArr[1];
            int sum=tempArr[2];
            arr[lower-1]+=sum;
            if(upper<n) arr[upper]-=sum;
        }
        long temp=0;

        for(int i=0;i<n;i++){
            temp += arr[i];
            if(temp> ans) ans=temp;
        }
        return ans;
    }
}
