package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {
    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 0, 5));
        queries.add(Arrays.asList(1, 1, 7));
        queries.add(Arrays.asList(1, 0, 3));
        queries.add(Arrays.asList(2, 1, 0));
        queries.add(Arrays.asList(2, 1, 1));
        int n = 2;
        List<Integer> output = dynamicArray(n, queries);
    }

    private static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }
        for (List<Integer> query : queries) {
            int x = query.get(1);
            int y = query.get(2);
            int type = query.get(0);

            int seq = (x ^ lastAnswer) % n;
            List<Integer> tempSeq = seqList.get(seq);
            if (type == 1) {
                tempSeq.add(y);
            } else {
                lastAnswer = tempSeq.get(y % tempSeq.size());
                output.add(lastAnswer);
//                System.out.println(lastAnswer);
            }
        }
        return output;
    }
}
