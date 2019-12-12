package com.training;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DiagonalDIfference {

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)
                );
        System.out.println(diagonalDifference(arr));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum = IntStream.range(0,arr.size())
        .mapToObj( i -> {
            List<Integer> list = arr.get(i);
            final int i1 = list.get(list.size() - i - 1) - list.get(i);
            System.out.println(i1);
            return i1;
        }).reduce(Integer::sum).get();
        return Math.abs(sum);
    }
}
