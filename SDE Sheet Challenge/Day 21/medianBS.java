class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while (low <= high) {
            int part1 = low + (high - low) / 2;
            int part2 = (n1 + n2 + 1) / 2 - part1;

            int maxLeft1 = 0;
            if (part1 == 0) {
                maxLeft1 = Integer.MIN_VALUE;
            } else {
                maxLeft1 = nums1[part1 - 1];
            }

            int minRight1 = 0;
            if (part1 == n1) {
                minRight1 = Integer.MAX_VALUE;
            } else {
                minRight1 = nums1[part1];
            }

            int maxLeft2 = 0;
            if (part2 == 0) {
                maxLeft2 = Integer.MIN_VALUE;
            } else {
                maxLeft2 = nums2[part2 - 1];
            }

            int minRight2 = 0;
            if (part2 == n2) {
                minRight2 = Integer.MAX_VALUE;
            } else {
                minRight2 = nums2[part2];
            }

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((n1 + n2) % 2 != 0) {
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                high = part1 - 1;
            } else {
                low = part1 + 1;
            }
        }

        return 0.0;
    }
}
