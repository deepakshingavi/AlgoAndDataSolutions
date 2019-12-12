package com.training;

public class DeleteDuplicateNodes {

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(2);
        head.next.next.next = new SinglyLinkedListNode(3);
        head.next.next.next.next = new SinglyLinkedListNode(4);
        removeDuplicates(head);
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode head1 = head;

        while (head1!=null){
            while(head1.next!=null && head1.data==head1.next.data) {
                head1.next = head1.next.next;
            }
            head1 = head1.next;
        }

        return head;
    }
}
