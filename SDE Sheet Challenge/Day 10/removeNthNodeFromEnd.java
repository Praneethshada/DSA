class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        int c = 0;
        ListNode temp = head;

        while (temp != null) {
            c++;
            temp = temp.next;
        }

        int d = c - n;
        if (d == 0) {
            return head.next;
        }
        temp = head;
        for (int i = 1; i < d; i++) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }
}