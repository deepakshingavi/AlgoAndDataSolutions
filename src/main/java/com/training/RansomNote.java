package com.training;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.HashMap;

import static java.util.stream.Collectors.*;

public class RansomNote {

    public static void main(String[] args) {
        String[] note = "ive got some coconuts".split(" ");
        String[] magazine = "ive got a lovely bunch of coconuts".split(" ");
        checkMagazine(magazine, note);

        note = "give one grand today".split(" ");
        magazine = "give me one grand today night".split(" ");
        checkMagazine(magazine, note);
    }

    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String,Long> map = new HashMap(Arrays.stream(note)
                .filter(innerWord -> !innerWord.trim().isEmpty())
                .map(innerWord ->  new SimpleEntry(innerWord, 1) )
                .collect(groupingBy(simpleEntry -> simpleEntry.getKey(), counting())));

        for (String word:magazine) {
            if(map.containsKey(word) && map.get(word)>0) {
                map.put(word,map.get(word)-1);
            }
        }

        boolean isNo = map.values().stream().filter(val -> val >0).count()>0;
        System.out.println(isNo?"No" : "Yes");

    }

}
