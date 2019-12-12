package com.training;

public class MergedTwoSortedLinkedLists {

    public static void main(String[] args) {

        SinglyLinkedListNode head2 = new SinglyLinkedListNode(1);
        head2.next = new SinglyLinkedListNode(3);
        head2.next.next = null;
        SinglyLinkedListNode head1 = new SinglyLinkedListNode(2);
        head1.next = null;

        SinglyLinkedListNode mergedHead = mergeLists(head1, head2);
        while (mergedHead != null) {
            System.out.println(mergedHead.data);
            mergedHead = mergedHead.next;
        }


        SinglyLinkedListNode head3 = new SinglyLinkedListNode(1);
        head2.next = new SinglyLinkedListNode(3);
        head2.next.next = null;
        SinglyLinkedListNode head4 = null;

        mergedHead = mergeLists(head4, head3);
        while (mergedHead != null) {
            System.out.println(mergedHead.data);
            mergedHead = mergedHead.next;
        }

    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        SinglyLinkedListNode traverseNode = new SinglyLinkedListNode(-1);
        SinglyLinkedListNode startNode = traverseNode;

        while (head1 != null || head2 != null) {
            if (head1 == null || (null!=head2 && head1.data > head2.data)) {
                traverseNode.next = head2;
                head2 = head2.next;
            }
            else if (null==head2 || ( head2.data > head1.data)) {
                traverseNode.next = head1;
                head1 = head1.next;
            } else {
                traverseNode.next = head1;
                head1 = head1.next;

                traverseNode = traverseNode.next;

                traverseNode.next = head2;
                head2 = head2.next;
            }
            traverseNode = traverseNode.next;
        }

        return startNode.next;
    }

    private static void traverseNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2, SinglyLinkedListNode traverseNode) {
        if (head1 == null && head2 == null) {
            traverseNode.next = null;
            return;
        }
        if (head1 == null || (head1.data > head2.data)) {
            traverseNode.next = head2;
            traverseNode(head1, head2.next, traverseNode.next);
        }
        else if (head2.data > head1.data) {
            traverseNode.next = head1;
            traverseNode(head1.next, head2, traverseNode.next);
        } else {
            traverseNode.next = head1;
            traverseNode = traverseNode.next;
            traverseNode.next = head2;
            traverseNode(head1.next, head2.next, traverseNode.next);
        }
    }
}
