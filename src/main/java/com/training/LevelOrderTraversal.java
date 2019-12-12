package com.training;

import java.util.ArrayDeque;
import java.util.Queue;
// Data structure to store a Binary Tree node

public class LevelOrderTraversal {



    // Function to print level order traversal of given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        // pointer to store current node
        Node curr;

        // run till queue is not empty
        while (!queue.isEmpty())
        {
            // process each node in queue and enqueue their
            // non-empty left and right child to queue
            curr = queue.poll();

            System.out.print(curr.data + " ");

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    // main function
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        levelOrderTraversal(root);
    }
}
