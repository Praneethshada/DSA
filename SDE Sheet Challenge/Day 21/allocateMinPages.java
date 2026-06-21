class Solution {
    public int findPages(int[] arr, int k) {
        if (arr.length < k) {
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int req = 1;
            int curr = 0;

            for (int i = 0; i < arr.length; i++) {
                if (curr + arr[i] > mid) {
                    req++;
                    curr = arr[i];
                } else {
                    curr += arr[i];
                }
            }

            if (req <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
