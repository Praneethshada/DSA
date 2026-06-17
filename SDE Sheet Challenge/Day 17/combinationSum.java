class Solution {
    void solve(int idx, int[] arr, int target, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (idx == arr.length || target < 0) {
            return;
        }

        // Pick the current element
        cur.add(arr[idx]);
        solve(idx, arr, target - arr[idx], cur, res);
        cur.remove(cur.size() - 1); // Backtrack

        // Skip the current element
        solve(idx + 1, arr, target, cur, res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), res);
        return res;
    }
}
