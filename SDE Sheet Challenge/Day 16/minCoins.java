class Solution {
    public int recursion(int[] coins, int rem, int[] memo) {
        if (rem == 0) {
            return 0;
        }
        if (rem < 0) {
            return -1;
        }

        if (memo[rem] != -2) {
            return memo[rem];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = recursion(coins, rem - coin, memo);

            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }

        if (min == Integer.MAX_VALUE) {
            memo[rem] = -1;
        } else {
            memo[rem] = min;
        }

        return memo[rem];
    }

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);

        return recursion(coins, amount, memo);
    }
}
