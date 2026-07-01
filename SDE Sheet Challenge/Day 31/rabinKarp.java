class Solution {
    int base = 31;
    int mod = 1000000007;

    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        ArrayList<Integer> ans = new ArrayList<>();

        int len = pattern.length();

        if (pattern.length() > text.length())
            return ans;

        long phash = 0;

        for (int i = 0; i < len; i++) {
            phash = (phash * base + pattern.charAt(i)) % mod;
        }

        long whash = 0;

        for (int i = 0; i < len; i++) {
            whash = (whash * base + text.charAt(i)) % mod;
        }

        if (phash == whash && (pattern.equals(text.substring(0, len)))) {
            ans.add(0);
        }

        long h = 1;

        for (int i = 0; i < len - 1; i++) {
            h = (h * base) % mod;
        }

        for (int i = 1; i <= text.length() - len; i++) {

            whash = (whash - (long) text.charAt(i - 1) * h) % mod;
            if (whash < 0) {
                whash += mod;
            }
            whash = (whash * base + text.charAt(i + len - 1)) % mod;

            if (phash == whash && (pattern.equals(text.substring(i, i + len)))) {
                ans.add(i);
            }
        }

        return ans;
    }
}