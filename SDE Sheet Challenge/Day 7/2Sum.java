class Solution {
    public int[] twoSum(int[] arr, int k) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int x = k - arr[i];
            if (hm.containsKey(x)) {
                ans[0] = i;
                ans[1] = hm.get(k - arr[i]);
                return ans;
            }
            hm.put(cur, i);
        }
        return ans;
    }
}