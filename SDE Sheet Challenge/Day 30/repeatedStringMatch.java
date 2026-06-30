class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int c = 1;

        while (sb.length() < b.length()) {
            sb.append(a);
            c++;
        }

        if (sb.indexOf(b) != -1) {
            return c;
        }

        sb.append(a);
        if (sb.indexOf(b) != -1) {
            return c + 1;
        }

        return -1;
    }
}
