package com.training;

public class SherlockAndAnagrams {

    static final int MAX = 256;

    static int sherlockAndAnagrams(String s) {
        int anagrams = 0;
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                anagrams = anagrams + search(s.substring(i, j), s.substring(i + 1));
            }
        }
        return anagrams;
    }

    static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int count = 0;
        // countP[]:  Store count of all
        // characters of pattern
        // countTW[]: Store count of current
        // window of text
        char[] countP = new char[MAX];
        char[] countTW = new char[MAX];
        for (int i = 0; i < M; i++) {
            (countP[pat.charAt(i)])++;
            (countTW[txt.charAt(i)])++;
        }

        // Traverse through remaining characters
        // of pattern
        for (int i = M; i < N; i++) {
            // Compare counts of current window of text with counts of pattern[]
            if (compare(countP, countTW))
                count++;

            // Add current character to current window
            (countTW[txt.charAt(i)])++;

            // Remove the first character of previous window
            countTW[txt.charAt(i - M)]--;
        }

        // Check for the last window in text
        if (compare(countP, countTW))
            count++;
//        System.out.println(pat + " in " + txt + " = " + count);
        return count;
    }

    static boolean compare(char arr1[], char arr2[]) {
        for (int i = 0; i < MAX; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
        System.out.println(sherlockAndAnagrams("kkkk"));
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("abcd"));
    }
}
