class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;

        long sum = (long) n * (n + 1) / 2;
        long square = (long) n * (n + 1) * (2 * n + 1) / 6;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i : arr) {
            sum -= i; // miss - repeat
            square -= (long) i * i; // miss^2 - repeat^2
        }

        long x = square / sum; // miss + repeat

        long miss = (x + sum) / 2;
        long repeat = x - miss;

        ans.add((int) (repeat));
        ans.add((int) (miss));

        return ans;
    }
}
