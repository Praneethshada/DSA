class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int c = 0;
        for (int i : nums) {
            if (i != 1) {
                ans = Math.max(ans, c);
                c = 0;
            } else {
                c++;
            }
        }
        return Math.max(ans, c);
    }
}