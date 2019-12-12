package com.training;

public class ReverseLinkedList {

    static SinglyLinkedListNode lastNode = null;

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(16);
        head.next = new SinglyLinkedListNode(12);
        head.next.next = new SinglyLinkedListNode(4);
        head.next.next.next = new SinglyLinkedListNode(2);
        head.next.next.next.next = new SinglyLinkedListNode(5);

        reverse(head);
        head = lastNode;
        while (head!=null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if(head==null || null==head.next) {
            lastNode = head;
            return head;
        }
        reverse(head.next).next = head;
        head.next = null;
        return head;
    }
}
