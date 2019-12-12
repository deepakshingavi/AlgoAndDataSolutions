package com.training;

public class TwoStrings {
    public static void main(String[] args) {
        System.out.println(
                twoStrings("hello","world")
        );
        System.out.println(
                twoStrings("hi","world")
        );
    }
    static String twoStrings(String s1, String s2) {
        String ans = "NO";
        String firstStr = s1;
        String secondStr = s2;
        if(s1.length() > s2.length()) {
            firstStr = s2;
            secondStr = s1;
        }
        int arr[] = new int[26];
        for (char a :firstStr.toCharArray()) {
            arr[a-97] = 1;
        }
        for (char a :secondStr.toCharArray()) {
            if(arr[a-97]==1){
                ans="YES";
                break;
            }
        }
        return ans;
    }
}
