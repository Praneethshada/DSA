class Solution {
    public ListNode rev(ListNode temp) {
        ListNode p = null;
        ListNode q = temp;
        ListNode r = null;

        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }

        return p;
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newhead = rev(slow);

        ListNode p1 = head;
        ListNode p2 = newhead;

        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}