package com.training;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    private static final Scanner scanner = new Scanner(System.in);
    private static final char APPEND = '+';
    private static final char DELETE = '-';

    public static void main(String[] args) {
        int nm = Integer.parseInt(scanner.nextLine());
        Stack stack = new Stack<>();
        StringBuilder strBuff = new StringBuilder();
        stack.push("");

        for (int i = 0; i < nm; i++) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {
                case "1":
                    strBuff.append(input[1]);
                    stack.push(APPEND);
                    stack.push(input[1].length());
                    break;
                case "2":
                    String delStr = strBuff.substring(strBuff.length() - Integer.parseInt(input[1]),strBuff.length());
                    strBuff.delete(strBuff.length() - Integer.parseInt(input[1]),strBuff.length());
                    stack.push(DELETE);
                    stack.push(delStr);
                    break;
                case "3":
                    System.out.println(strBuff.charAt(Integer.parseInt(input[1]) - 1));
                    break;
                case "4":
                    Object oldStr =  stack.pop();
                    char operation = (char)stack.pop();
                    if(DELETE == operation) {
                        strBuff.append(oldStr);
                    }else {
                        strBuff.delete(strBuff.length()-(int)oldStr,strBuff.length());
                    }
                    break;
            }
        }
        scanner.close();
    }
}
