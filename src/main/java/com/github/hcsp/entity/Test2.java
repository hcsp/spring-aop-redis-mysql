package com.github.hcsp.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test2 {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.right = node5;
        List<Integer> result = inorderTraversal(node1);
        List<Integer> list1 = new ArrayList<>();
        inorderTraversal(node1, list1);
        bfs(node1);

    }

    public  static  void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            System.out.println(head.value);
            if(head.left!=null) {
                queue.add(head.left);
            }
            if(head.right!=null) {
                queue.add(head.right);
            }
         }
    }


    public static void inorderTraversal(Node root, List<Integer> list) {
        if (root.left != null) {
            inorderTraversal(root.left, list);
        }

        list.add(root.value);

        if (root.right != null) {
            inorderTraversal(root.right, list);
        }
    }

    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> leftResult;
        if (root.left != null) {
            leftResult = inorderTraversal(root.left);
        } else {
            leftResult = new ArrayList<>();
        }

        int value = root.value;

        List<Integer> rightRusult;
        if (root.right != null) {
            rightRusult = inorderTraversal(root.right);
        } else {
            rightRusult = new ArrayList<>();
        }

        List<Integer> myResult = new ArrayList<>();
        myResult.addAll(leftResult);
        myResult.add(value);
        myResult.addAll(rightRusult);
        return myResult;
    }

}
