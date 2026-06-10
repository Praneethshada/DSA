class Solution {
    public void deleteNode(ListNode node) {
        int x = (node.next).val;
        ListNode temp = (node.next).next;
        node.val = x;
        node.next = temp;
    }
}