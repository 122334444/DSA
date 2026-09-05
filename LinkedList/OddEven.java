package LinkedList;

class OddEven {

    static class ListNode {

        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head, even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;//not 2 next because updated
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String args[]) {

    }
}
