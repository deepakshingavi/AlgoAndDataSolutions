package com.training;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsBalanced {
    final static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }

    static String isBalanced(String s) {
        if (s.length() % 2 != 0) {
            return "NO";
        }
        boolean isBalanced = true;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        try {
            for (int i = 0; isBalanced && (i < chars.length); i++) {
                if (map.containsKey(chars[i])) {
                    stack.push(chars[i]);
                } else if (map.getOrDefault(stack.pop(),' ') != chars[i]) {
                    isBalanced = false;
                }
            }
        } catch (EmptyStackException ex) {
            isBalanced = false;
        } finally {
            if (isBalanced && stack.isEmpty()) {
                return "YES";
            } else {
                return "NO";
            }
        }

    }
}
