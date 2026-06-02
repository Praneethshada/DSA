class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pt = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            int val = 1;
            row.add(val);

            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    row.add(1);
                } else {
                    val = val * (i - j + 1) / j;
                    row.add(val);
                }
            }
            pt.add(row);
        }

        return pt;
    }
}
