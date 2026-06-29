class Solution {
    public int get(char ch) {
        if (ch == 'I') {
            return 1;
        } else if (ch == 'V') {
            return 5;
        } else if (ch == 'X') {
            return 10;
        } else if (ch == 'L') {
            return 50;
        } else if (ch == 'C') {
            return 100;
        } else if (ch == 'D') {
            return 500;
        } else if (ch == 'M') {
            return 1000;
        }

        return -1;
    }

    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (get(s.charAt(i)) < get(s.charAt(i + 1))) {
                ans -= get(s.charAt(i));
            } else {
                ans += get(s.charAt(i));
            }
        }

        ans += get(s.charAt(s.length() - 1));

        return ans;
    }
}