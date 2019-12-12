package com.training;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

public class TreeTopVIew {


    static void getVerticalOrder(Node root, int hd,
                                 TreeMap<Integer, Vector<Integer>> m)
    {
        // Base case
        if(root == null)
            return;

        //get the vector list at 'hd'
        Vector<Integer> get =  m.get(hd);

        // Store current node in map 'm'
        if(get == null)
        {
            get = new Vector<>();
            get.add(root.data);
        }
        else
            get.add(root.data);

        m.put(hd, get);

        // Store nodes in left subtree
        getVerticalOrder(root.left, hd-1, m);

        // Store nodes in right subtree
        getVerticalOrder(root.right, hd+1, m);
    }

    // The main function to print vertical order of a binary tree
    // with the given root
    static void printVerticalOrder(Node root)
    {
        // Create a map and store vertical order in map using
        // function getVerticalOrder()
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
        int hd =0;
        getVerticalOrder(root,hd,m);

        // Traverse the map and print nodes at every horigontal
        // distance (hd)
        boolean flip = false ;
        int previousSize = 0;
        for (Map.Entry<Integer, Vector<Integer>> entry : m.entrySet()) {
            flip = !flip && previousSize > entry.getValue().size();
            if(flip)
                System.out.print(entry.getValue() + " "+entry.getKey());
            else
                System.out.print(entry.getValue() + " "+entry.getKey());
            previousSize = entry.getValue().size();
        }
    }

    static int count=0;

    //1  2  7  60 3  4  5   6
    //0 -2 -4 -6 -6 -8 -10 -12

    static int rightSide=Integer.MAX_VALUE;
    static int leftSide=Integer.MIN_VALUE;

    public static void topView(Node root) {
        if(root.left!=null && count>=0){
            if(null!=root.right) {
                count--;
                topView(root.right);
            }
            count++;
            topView(root.left);
        }
        System.out.print(root.data+ " " + count + " ");
        count--;
        if(root.right!=null && count<0){
            count--;
            topView(root.right);
            if(null!=root.left) {
                count++;
                topView(root.left);
            }

        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        printVerticalOrder(root);
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
    }

    @Override
    public String toString() {
        return data+"";
    }
}

