package com.training;

public class SortedDoublyListInsert {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedListNode head = new DoublyLinkedListNode(1);
        head.next = new DoublyLinkedListNode(3);
        head.next.next = new DoublyLinkedListNode(4);
        head.next.next.next = new DoublyLinkedListNode(10);

        head.prev = null;
        head.next.prev = head;
        head.next.next.prev = head.next;
        head.next.next.next.prev = head.next.next;
        sortedInsert(head,5);
    }
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode toInsert = new DoublyLinkedListNode(data);
        DoublyLinkedListNode head1 = head;
        if(head==null) {
            return toInsert;
        }
        while (head!=null) {
            if(head.data >= data) {
                toInsert.next = head;
                toInsert.prev = head.prev;
                if(null!=head.prev) {
                    head.prev.next = toInsert;
                } else
                    head.prev = toInsert;
                break;
            }
            if(head.next==null) {
                head.next = toInsert;
                toInsert.prev = head;
                break;
            }
            head = head.next;
        }

        while (head1.prev!=null) {
            head1= head1.prev;
        }
        return head1;
    }
}
