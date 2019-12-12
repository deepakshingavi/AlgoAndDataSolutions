package com.training;

public class CycleDetection {
    public static void main(String[] args) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(1);
        node.next = new SinglyLinkedListNode(2);
        node.next.next = new SinglyLinkedListNode(3);
        node.next.next.next = node.next;
        hasCycle(node);
    }
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode head1 = head;
        try {
            while (head != null) {
                head = head.next;
                head1 = head1.next.next;
                if (head == head1) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException nex) {
            return false;
        }
    }
}
