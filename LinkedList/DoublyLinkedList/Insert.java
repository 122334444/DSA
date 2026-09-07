package LinkedList.DoublyLinkedList;

public class Insert {
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

    // 1. Insert at Head
    public static Node insertHead(Node head, int data) {

        Node newNode = new Node(data);

        // Empty list
        if (head == null) {
            return newNode;
        }

        newNode.next = head;
        head.prev = newNode;

        return newNode;
    }

    // 2. Insert at Tail
    public static Node insertTail(Node head, int data) {

        Node newNode = new Node(data);

        // Empty list
        if (head == null) {
            return newNode;
        }

        Node temp = head;

        // Move to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    // 3. Insert at Kth Position
    public static Node insertKth(Node head, int k, int data) {

        Node newNode = new Node(data);

        // Empty list
        if (head == null) {
            if (k == 1)
                return newNode;

            return head;
        }

        // Insert at first position
        if (k == 1) {
            newNode.next = head;
            head.prev = newNode;

            return newNode;
        }

        Node temp = head;

        // Move to kth node
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }

        // If position doesn't exist
        if (temp == null) {
            return head;
        }

        // Insert before temp
        Node back = temp.prev;

        newNode.prev = back;
        newNode.next = temp;

        back.next = newNode;
        temp.prev = newNode;

        return head;
    }

    // 4. Insert Before a Given Node
    public static Node insertBeforeNode(Node head, Node node, int data) {

        if (head == null)
            return null;

        Node newNode = new Node(data);

        // If node is head
        if (node == head) {

            newNode.next = head;
            head.prev = newNode;

            return newNode;
        }

        Node back = node.prev;

        newNode.prev = back;
        newNode.next = node;

        back.next = newNode;
        node.prev = newNode;

        return head;
    }

    // Print DLL
    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Convert Array to DLL
    public static Node arrToDLL(int arr[]) {

        if (arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {

            Node temp = new Node(arr[i]);

            prev.next = temp;
            temp.prev = prev;

            prev = temp;
        }

        return head;
    }

    public static void main(String args[]) {

        int arr[] = { 1, 2, 3, 4, 5 };

        Node head = arrToDLL(arr);

        // Insert at head
        head = insertHead(head, 10);
        printList(head);
        // 10 1 2 3 4 5

        // Insert at tail
        head = insertTail(head, 20);
        printList(head);
        // 10 1 2 3 4 5 20

        // Insert at 3rd position
        head = insertKth(head, 3, 30);
        printList(head);
        // 10 1 30 2 3 4 5 20

        // Insert before a given node
        Node node = head.next.next.next; // node containing 2

        head = insertBeforeNode(head, node, 40);
        printList(head);
        // 10 1 30 40 2 3 4 5 20
    }
}
