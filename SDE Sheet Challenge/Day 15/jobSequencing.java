class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        int maxDeadline = 0;
        for (int[] job : Jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        int[] timeline = new int[maxDeadline + 1];
        Arrays.fill(timeline, -1);

        int countJobs = 0;
        int maxProfit = 0;

        for (int[] job : Jobs) {
            int deadline = job[1];
            int profit = job[2];
            for (int t = deadline; t > 0; t--) {
                if (timeline[t] == -1) {
                    timeline[t] = job[0];
                    countJobs++;
                    maxProfit += profit;
                    break;
                }
            }
        }

        return new int[] { countJobs, maxProfit };
    }
}
