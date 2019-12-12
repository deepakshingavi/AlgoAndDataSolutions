package com.training;

import java.time.format.DateTimeFormatter;

public class TimeConversion {
    public static void main(String[] args) {
        System.out.println(timeConversion("07:05:45PM"));
    }

    static String timeConversion(String s) {
        return DateTimeFormatter.ofPattern("HH:mm:ss").format(DateTimeFormatter.ofPattern("hh:mm:ssa").parse(s));
    }
}
