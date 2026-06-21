class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }

        int n1 = a.length;
        int n2 = b.length;

        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high) {
            int part1 = low + (high - low) / 2;
            int part2 = k - part1;

            int maxLeft1 = 0;
            if (part1 == 0) {
                maxLeft1 = Integer.MIN_VALUE;
            } else {
                maxLeft1 = a[part1 - 1];
            }

            int minRight1 = 0;
            if (part1 == n1) {
                minRight1 = Integer.MAX_VALUE;
            } else {
                minRight1 = a[part1];
            }

            int maxLeft2 = 0;
            if (part2 == 0) {
                maxLeft2 = Integer.MIN_VALUE;
            } else {
                maxLeft2 = b[part2 - 1];
            }

            int minRight2 = 0;
            if (part2 == n2) {
                minRight2 = Integer.MAX_VALUE;
            } else {
                minRight2 = b[part2];
            }

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                return Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2) {
                high = part1 - 1;
            } else {
                low = part1 + 1;
            }
        }

        return 0;
    }
}
