class Solution {

    static class Pair {
        int sum;
        int idxA;
        int idxB;

        Pair(int sum, int idxA, int idxB) {
            this.sum = sum;
            this.idxA = idxA;
            this.idxB = idxB;
        }
    }

    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length;
        int m = b.length;

        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.sum, p1.sum));

        HashSet<String> visited = new HashSet<>();

        int i = n - 1;
        int j = m - 1;

        maxHeap.add(new Pair(a[i] + b[j], i, j));
        visited.add(i + "," + j);

        while (k > 0 && !maxHeap.isEmpty()) {
            Pair curr = maxHeap.poll();
            result.add(curr.sum);
            k--;

            int currA = curr.idxA;
            int currB = curr.idxB;

            // 1: Move left in array 'a' (next largest element in a)
            if (currA - 1 >= 0) {
                String key = (currA - 1) + "," + currB;
                if (!visited.contains(key)) {
                    maxHeap.add(new Pair(a[currA - 1] + b[currB], currA - 1, currB));
                    visited.add(key);
                }
            }

            // 2: Move left in array 'b' (next largest element in b)
            if (currB - 1 >= 0) {
                String key = currA + "," + (currB - 1);
                if (!visited.contains(key)) {
                    maxHeap.add(new Pair(a[currA] + b[currB - 1], currA, currB - 1));
                    visited.add(key);
                }
            }
        }

        return result;
    }
}
