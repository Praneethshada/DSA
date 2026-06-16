class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length && p2 < g.length) {
            if (g[p2] <= s[p1]) {
                p2++;
                ans++;
            }
            p1++;
        }
        return ans;
    }
}