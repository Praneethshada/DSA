class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        int idx = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (merged.get(idx)[1] < intervals[i][0]) {
                merged.add(intervals[i]);
                idx++;
            } else {
                merged.get(idx)[1] = Math.max(intervals[i][1], merged.get(idx)[1]);
            }
        }
        int[][] ans = new int[idx + 1][2];
        int i = 0;
        for (int[] inv : merged) {
            ans[i] = inv;
            i++;
        }

        return ans;
    }
}