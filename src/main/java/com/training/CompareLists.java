package com.training;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompareLists {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(17, 28, 30);
        List<Integer> b = Arrays.asList(99, 16, 8);
        System.out.println(compareTriplets(a, b));
    }

    static List<Integer> compareTriplets1(List<Integer> a, List<Integer> b) {
        Integer arr [] = {0,0};
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                arr[0] = arr[0] + 1;
            } else if (a.get(i) < b.get(i)) {
                arr[1] = arr[1] + 1;
            }
        }
        return Arrays.asList(arr);
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        final Map<Integer, Integer> tempMap = IntStream.range(0, a.size())
                .mapToObj(i -> {
                    int score = 0;
                    if (a.get(i) > b.get(i)) {
                        score = 1;
                    } else if (a.get(i) < b.get(i)) {
                        score = 2;
                    }
                    return score;
                })
                .filter(i -> i != 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        List<Integer> output = new ArrayList<>(
                        tempMap
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (v1, v2) -> {
                                    throw new IllegalStateException();
                                },
                                LinkedHashMap<Integer, Integer>::new)
                        )
                        .values());
        return output;
    }
}
