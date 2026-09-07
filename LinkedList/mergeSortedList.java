package LinkedList;

public class mergeSortedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node merge(Node head1, Node head2) {
        Node node1 = head1;
        Node node2 = head2;

        Node dummy = new Node(-1);
        Node temp = dummy;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }

        while (node1 != null) {
            temp.next = node1;
            node1 = node1.next;
        }

        while (node2 != null) {
            temp.next = node2;
            node2 = node2.next;
        }

        return dummy.next;

    }

    public static void main(String args[]) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        Node merged = merge(head1, head2);
        while (merged != null) {
            System.out.print(merged.data + " ");
            merged = merged.next;
        }
    }
}
