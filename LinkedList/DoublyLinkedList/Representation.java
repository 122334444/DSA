package LinkedList.DoublyLinkedList;

public class Representation {
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

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };

        Node head = ArrToDLL(arr);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

}
