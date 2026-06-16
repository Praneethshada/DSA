class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {

        int n = arr.length;
        int p = (int) Math.pow(2, n);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);

        for (int i = 1; i < p; i++) {
            int sum = 0;
            int mask = i;
            int idx = 0;
            while (mask > 0) {
                if ((mask & (int) 1) != 0) {
                    sum += arr[idx];
                }
                idx++;
                mask = mask >> 1;
            }

            ans.add(sum);
        }

        return ans;
    }
}