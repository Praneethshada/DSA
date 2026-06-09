class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            if (list1 == null && list2 == null) {
                return null;
            } else if (list1 == null) {
                return list2;
            } else {
                return list1;
            }
        }

        ListNode merge = new ListNode(-1);
        ListNode temp = merge;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
            temp.next = null;
        }

        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }

        return merge.next;
    }
}