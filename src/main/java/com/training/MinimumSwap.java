package com.training;

import java.util.Arrays;

public class MinimumSwap {

    public static void main(String[] args) {
        int[] arr = {1,3, 5, 2, 4, 6, 7};
        int swapsCount = minimumSwaps(arr);
        System.out.println(swapsCount);

        int[] arr1 = {2, 3, 4, 1, 5};
        swapsCount = minimumSwaps(arr1);
        System.out.println(swapsCount);
    }

    private static int minimumSwaps(int[] arr) {
        int[] tempArr = new int[arr.length+1];
        System.arraycopy(arr,0,tempArr,1,arr.length);
        int swapCount =0;
        for (int i = 1; i < tempArr.length; ) {
            if(tempArr[i] == i){
                i++;
            } else {
                int swap = tempArr[tempArr[i]];
                tempArr[tempArr[i]] = tempArr[i];
                tempArr[i] = swap;
                swapCount++;
            }
        }
        return swapCount;
    }

}
