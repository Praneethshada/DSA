class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        ArrayList<Integer> result = new ArrayList<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Put the first element of each row into the heap
        for (int i = 0; i < mat.length; i++) {
            if (mat[i].length > 0) {
                minHeap.offer(new int[] { mat[i][0], i, 0 });
            }
        }

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int val = curr[0];
            int r = curr[1];
            int c = curr[2];

            result.add(val);

            if (c + 1 < mat[r].length) {
                minHeap.offer(new int[] { mat[r][c + 1], r, c + 1 });
            }
        }

        return result;
    }
}
