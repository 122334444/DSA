package LinkedList.DoublyLinkedList;

public class Delete {
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

    public static Node deleteHead(Node head) {
        if (head == null || head.next == null)
            return null;

        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;

        return head;
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;

        }

        Node prev = tail.prev;
        prev.next = null;
        tail.prev = null;

        return head;
    }

    public static Node deleteKthNode(Node head, int k) {

        if (head == null)
            return null;

        Node temp = head;

        // Move to kth node
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }

        // k is greater than number of nodes
        if (temp == null)
            return head;

        // If deleting head
        if (temp.prev == null) {
            return deleteHead(head);
        }

        // Connect previous node to next node
        if (temp.prev != null)
            temp.prev.next = temp.next;

        // Connect next node to previous node
        if (temp.next != null)
            temp.next.prev = temp.prev;

        // Disconnect temp
        temp.prev = null;
        temp.next = null;

        return head;
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

    public static void main(String args[]) {

        int arr[] = { 1, 2, 3, 4, 5 };

        // Test deleteHead
        Node head = ArrToDLL(arr);

        Node newHead = deleteHead(head);

        Node temp = newHead;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();

        // Test deleteTail on a fresh list
        Node head2 = ArrToDLL(arr);

        Node newHead2 = deleteTail(head2);

        temp = newHead2;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

}
