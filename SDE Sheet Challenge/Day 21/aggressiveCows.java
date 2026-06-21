class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int c = 1;
            int pos = stalls[0];

            for (int i = 1; i < stalls.length; i++) {
                if (stalls[i] - pos >= mid) {
                    c++;
                    pos = stalls[i];
                }
            }

            if (c >= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
