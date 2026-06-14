class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total = 0;

        int left = 0;
        int right = 0;

        int p1 = 0;
        int p2 = n - 1;

        while (p1 < p2) {
            left = Math.max(left, height[p1]);
            right = Math.max(right, height[p2]);

            if (left < right) {
                total += left - height[p1];
                p1++;
            } else {
                total += right - height[p2];
                p2--;
            }
        }

        return total;
    }
}