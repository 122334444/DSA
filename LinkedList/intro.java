package LinkedList;

import java.util.*;
import java.io.*;

public class intro {

    static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        static Node head;
        static Node tail;
        static int size;

        void addLast(LinkedList ll, int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = null;
                tail = temp;
            }

            size++;
        }

        int size() {
            return size;
        }

        public void display(LinkedList ll) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "");
                temp = temp.next;
            }
            System.out.println();
        }

    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addLast(ll, 10);
        ll.addLast(ll, 20);
        ll.addLast(ll, 30);
        System.out.println("Head: " + ll.head.data);
        System.out.println("Tail: " + ll.tail.data);
        System.out.println("Size: " + ll.size);
        ll.display(ll);

    }
}
