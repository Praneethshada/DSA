/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0;
        int b = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;

        // count
        while (p1 != null) {
            a++;
            p1 = p1.next;
        }
        while (p2 != null) {
            b++;
            p2 = p2.next;
        }
        // level
        while (a > b) {
            a--;
            headA = headA.next;
        }
        while (b > a) {
            b--;
            headB = headB.next;
        }
        // move
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}