package com.training;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlusMinus {

    public static void main(String[] args) {
        int[] arr = {-4 ,3 ,-9 ,0 ,4 ,1};
        plusMinus(arr);
    }

    static void plusMinus(int[] arr) {
        Map<Integer, Integer> map = IntStream.of(arr).mapToObj(i -> {
            if(i < 0 ) {
                return -1;
            } else if(i > 0 ) {
                return 1;
            }
            return 0;
        }).collect(Collectors.groupingBy(Function.identity(),Collectors.summingInt(e -> 1)));

        BigDecimal positive = new BigDecimal(map.getOrDefault(1,0).doubleValue() /arr.length);
        positive = positive.setScale(6, RoundingMode.HALF_UP);
        System.out.println(String.format("%1$-8s", positive.toString()).replace(' ', '0'));
        BigDecimal negative = new BigDecimal(map.getOrDefault(-1,0).doubleValue() /arr.length);
        negative = negative.setScale(6, RoundingMode.HALF_UP);
        System.out.println(String.format("%1$-8s",  negative.toString()).replace(' ', '0'));
        BigDecimal zeros = new BigDecimal(map.getOrDefault(0,0).doubleValue() /arr.length);
        zeros = zeros.setScale(6, RoundingMode.HALF_UP);
        System.out.println(String.format("%1$-8s", zeros.toString()).replace(' ', '0'));
    }
}
