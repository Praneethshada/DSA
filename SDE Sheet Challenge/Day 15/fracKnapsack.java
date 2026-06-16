class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;

        double[][] mat = new double[n][2];

        for (int i = 0; i < n; i++) {
            mat[i][0] = i;
            mat[i][1] = (double) val[i] / wt[i];
        }

        Arrays.sort(mat, (a, b) -> Double.compare(b[1], a[1]));

        double ans = 0.0;
        long rem = cap;

        for (int i = 0; i < n; i++) {
            if (rem == 0)
                break;

            int idx = (int) mat[i][0];
            double ratio = mat[i][1];

            if (wt[idx] <= rem) {
                ans += val[idx];
                rem -= wt[idx];
            } else {
                ans += ratio * rem;
                rem = 0;
            }
        }

        return ans;
    }
}
