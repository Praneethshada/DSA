class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            arr.add(e.getKey());
        }

        arr.sort((a, b) -> hm.get(b) - hm.get(a));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr.get(i);
        }
        return result;
    }
}
