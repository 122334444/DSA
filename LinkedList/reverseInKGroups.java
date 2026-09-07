package LinkedList;

public class reverseInKGroups {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode kth = getKth(temp, k);
            if (kth == null) {
                if (prev != null)
                    prev.next = temp;
                break;
            }
            ListNode next = kth.next;
            kth.next = null;
            reverseLL(temp);
            if (temp == head) {
                head = kth;
            } else {
                prev.next = kth;
            }
            temp.next = next;
            prev = temp;
            temp = next;
        }
        return head;
    }

    private ListNode getKth(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
