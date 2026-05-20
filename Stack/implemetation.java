package Stack;

import java.util.*;

public class implemetation {

    // USING ARAAYLIST
    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public int peek() {
            int top = list.get(list.size() - 1);
            return top;
        }

    }

    // USING LINKEDLIST

    static class StackLinkedList {
        static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        Node top;

        public boolean isEmpty() {
            return top == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                top = newNode;
            }
            newNode.next = top;// adding initially
            top = newNode;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int val = top.data;
            top = top.next;// head changed
            return val;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            int val = top.data;
            return val;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
                return;
            }

            Node temp = top;

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public static void main(String args[]) {
        // Stack s = new Stack();
        // s.push(0);
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // int a = s.peek();
        // System.out.println(a);
        // s.pop();
        // int b = s.peek();
        // System.out.println(b);

        StackLinkedList st = new StackLinkedList();

        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println("Top Element: " + st.peek());

        System.out.println("Popped: " + st.pop());
        System.out.println("Top Element: " + st.peek());

    }
}
