class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> pf = new HashMap<>();
        pf.put(0, -1);

        int sum = 0;
        int maxlen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (pf.containsKey(sum - k)) {
                maxlen = Math.max(maxlen, i - pf.get(sum - k));
            }

            if (!pf.containsKey(sum)) {
                pf.put(sum, i);
            }
        }

        return maxlen;
    }
}
