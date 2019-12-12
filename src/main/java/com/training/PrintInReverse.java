package com.training;

public class PrintInReverse {

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(16);
        head.next = new SinglyLinkedListNode(12);
        head.next.next = new SinglyLinkedListNode(4);
        head.next.next.next = new SinglyLinkedListNode(2);
        head.next.next.next.next = new SinglyLinkedListNode(5);

        reversePrint(head);
    }

    private static void reversePrint(SinglyLinkedListNode head) {
        if (head.next == null) {
            System.out.println(head.data);
            return;
        }
        reversePrint(head.next);
        System.out.println(head.data);
    }
}

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return data + "";
    }
}
