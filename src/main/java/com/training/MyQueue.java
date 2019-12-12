package com.training;

import java.util.Scanner;
import java.util.Stack;

public class MyQueue<T> {

    Stack<T> stackNewestOnTop = new Stack<T>();
    Stack<T> stackOldestOnTop = new Stack<T>();

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public T peek() {
        if(stackOldestOnTop.isEmpty()) {
            while(!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
        return stackOldestOnTop.peek();
    }

    public T dequeue() {
        if(stackOldestOnTop.isEmpty()) {
            while (!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
        return stackOldestOnTop.pop();
    }

    public void enqueue(T i) {
        stackNewestOnTop.push(i);
    }

}
