class Solution {
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        int ans = 0;

        for (int i : arr) {
            if (!set.contains(i - 1)) {
                int num = i;
                int c = 0;

                while (set.contains(num)) {
                    c++;
                    num++;
                }

                ans = Math.max(ans, c);
            }
        }

        return ans;
    }
}
