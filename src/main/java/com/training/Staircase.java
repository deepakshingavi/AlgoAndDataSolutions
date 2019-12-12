package com.training;

import java.util.stream.IntStream;

public class Staircase {
    public static void main(String[] args) {
        staircase(4);
    }

    static void staircase(int n) {
        IntStream.range(0, n).forEach(i -> {
            System.out.print(String.format("%1$"+(n-i)+"s", "").substring(1));
            System.out.println(String.format("%1$-"+(i+1)+"s", "#").replace(' ','#'));
            }
        );
    }
}
