class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode q = null;
        ListNode r = null;

        while (p != null) {
            r = q;
            q = p;
            p = p.next;

            q.next = r;
        }

        return q;
    }
}