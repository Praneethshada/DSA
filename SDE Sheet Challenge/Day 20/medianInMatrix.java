class Solution {
    public int median(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;

        int min = mat[0][0];
        int max = mat[0][C - 1];
        for (int i = 1; i < R; i++) {
            if (mat[i][0] < min) {
                min = mat[i][0];
            }
            if (mat[i][C - 1] > max) {
                max = mat[i][C - 1];
            }
        }

        int desired = (R * C + 1) / 2;

        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;

            for (int i = 0; i < R; i++) {
                count += countLE(mat[i], mid);
            }

            if (count < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    private int countLE(int[] row, int target) {
        int low = 0;
        int high = row.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
