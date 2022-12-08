package com.github.hcsp.entity;

public class Test {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {


        Node node1 = new Node(111);
        Node node2 = new Node(222);
        Node node3 = new Node(333);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(isLoop(node1));
    }

    public static boolean isLoop(Node head) {
        Node p = head, q = head;
        while(true) {
            if (p.next == null) {
                return false;
            }
            p = p.next;
            if (q.next == null || q.next.next == null) {
                return false;
            }
            q = q.next.next;
            if (q == p) {
                return true;
            }
        }
    }

}
