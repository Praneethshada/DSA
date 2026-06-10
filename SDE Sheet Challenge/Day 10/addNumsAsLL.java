class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;

        ListNode head = new ListNode();
        ListNode temp = head;

        while (p1 != null || p2 != null || carry == 1) {
            int sum = 0;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode x = new ListNode(sum % 10);
            temp.next = x;
            temp = temp.next;
        }
        return head.next;
    }
}