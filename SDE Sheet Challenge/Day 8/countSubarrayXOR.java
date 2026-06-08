class Solution {
    public long subarrayXor(int arr[], int k) {
        long count = 0;

        HashMap<Integer, Integer> pf = new HashMap<>();

        int xor = 0;

        for (int i : arr) {
            xor ^= i;

            if (xor == k) {
                count++;
            }

            int t = xor ^ k;
            if (pf.containsKey(t)) {
                count += pf.get(t);
            }

            pf.put(xor, pf.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}