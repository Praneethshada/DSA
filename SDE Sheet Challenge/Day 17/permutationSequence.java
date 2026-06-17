class Solution {
    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k = k - 1;
        StringBuilder ans = new StringBuilder();

        for (int i = n; i > 0; i--) {
            int block = factorial(i - 1);
            int idx = k / block;
            ans.append(nums.get(idx));
            nums.remove(idx);
            k = k % block;
        }

        return ans.toString();
    }
}