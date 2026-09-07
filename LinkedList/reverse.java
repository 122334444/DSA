package LinkedList;

public class reverse {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseLLRec(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseLLRec(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static Node reverseLLData(Node head) {
        Node curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int arr[] = new int[size];
        curr = head;
        for (int i = 0; i < size; i++) {
            arr[i] = curr.data;
            curr = curr.next;
        }
        curr = head;
        for (int i = size - 1; i >= 0; i--) {
            curr.data = arr[i];
            curr = curr.next;
        }
        return head;
    }

    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        Node curr = reverseLL(head);
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
