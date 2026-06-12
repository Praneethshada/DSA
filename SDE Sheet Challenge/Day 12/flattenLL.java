class Solution {
    public Node merge(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node res = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            } else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }

        if (list1 != null) {
            res.bottom = list1;
        } else {
            res.bottom = list2;
        }

        if (dummy.bottom != null) {
            dummy.bottom.next = null;
        }

        return dummy.bottom;
    }

    public Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        Node merged = flatten(root.next);
        return merge(root, merged);
    }
}