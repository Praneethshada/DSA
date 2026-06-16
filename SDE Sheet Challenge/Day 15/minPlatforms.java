class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        int n = Arrival.length;
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int platforms = 1;
        int ans = 1;
        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (Arrival[i] <= Departure[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            ans = Math.max(ans, platforms);
        }

        return ans;
    }
}