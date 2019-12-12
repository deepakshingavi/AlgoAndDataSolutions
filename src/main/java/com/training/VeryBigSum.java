package com.training;

import java.util.Arrays;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class VeryBigSum {

    public static void main(String[] args) {
        long[] ar= {1,2};
        Long sum = LongStream.of(ar).sum();
    }
}
