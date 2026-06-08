class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }

        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            int[] seen = new int[128];
            seen[s.charAt(i)]++;
            for (int j = i + 1; j < s.length(); j++) {
                if (seen[s.charAt(j)] != 0) {
                    max = Math.max(max, len);
                    break;
                } else {
                    len++;
                    seen[s.charAt(j)]++;
                }
            }
            max = Math.max(max, len);
        }

        return max;
    }
}
