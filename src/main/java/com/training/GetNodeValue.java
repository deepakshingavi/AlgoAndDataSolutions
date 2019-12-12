package com.training;

public class GetNodeValue {

    public static void main(String[] args) {

        int positionFromTail=0;
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        System.out.println(getNode(head,positionFromTail));
        
    }

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        int length = 0;
        SinglyLinkedListNode head1= head;

        while (head!=null) {
            length++;
            head = head.next;
        }

        for (int i = length - positionFromTail-1; i > 0 ; i--) {
            head1 = head1.next;
        }
        return head1.data;

    }


}
