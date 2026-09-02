package LinkedList.DoublyLinkedList;

public class ReverseDLL {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node ArrToDLL(int arr[]) {
        int n = arr.length;

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < n; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }
        return head;
    }

    public static Node reverseDLL(Node head) {

        if (head == null)
            return null;

        Node current = head;
        Node newHead = null;

        while (current != null) {

            // Swap next and prev
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;

            // This will become the new head
            newHead = current;

            // Move to the original next node
            current = temp;
        }

        return newHead;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };

        Node head = ArrToDLL(arr);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();

        head = reverseDLL(head);
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
