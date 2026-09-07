package LinkedList;

import java.util.*;

public class remove {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeFirst(Node head) {
        if (head == null)
            return null;

        return head.next;
    }

    public static void removeLast(Node head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }

    public static void removeIdx(Node head, int idx) {
        if (head == null) {
            return;
        }
        if (idx == 0) {
            head = head.next;
            return;
        }
        Node curr = head;
        for (int i = 0; i < idx - 1; i++) {
            if (curr.next == null) {
                return;
            }
            curr = curr.next;
        }
        if (curr.next == null) {
            return;
        }

        curr.next = curr.next.next;
    }

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        // removeLast(head);
        Node newHead = removeFirst(head);
        Node curr = newHead;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
