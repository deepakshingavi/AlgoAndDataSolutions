package com.training;

public class CompareLinkedLists {
    public static void main(String[] args) {
        SinglyLinkedListNode head2 = new SinglyLinkedListNode(1);
        head2.next = new SinglyLinkedListNode(2);
        head2.next.next = null;
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(1);
        head1.next = null;
        System.out.println(compareLists(head2,head1));
    }
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            if(head1==null && head2==null) {
                return true;
            }
            else if (head1!=null && head2!=null && head1.data == head2.data) {
                return compareLists(head1.next,head2.next);
            }
            return false;
    }
}
