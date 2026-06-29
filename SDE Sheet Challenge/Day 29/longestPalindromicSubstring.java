class Solution {
    public int[] expand(String s, int left, int right) {
        while ((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return new int[] { right - left - 1, left + 1 };
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] odd = expand(s, i, i);
            int[] even = expand(s, i, i + 1);

            if (odd[0] >= even[0] && odd[0] > end - start) {
                start = odd[1];
                end = start + odd[0];
            } else if (even[0] > odd[0] && even[0] > end - start) {
                start = even[1];
                end = start + even[0];
            }
        }
        return s.substring(start, end);
    }
}