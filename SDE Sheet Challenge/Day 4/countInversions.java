class Solution {

    static int merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[i + l];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[m + 1 + j];
        }

        int res = 0;
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                res += (n1 - i);
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }

        return res;
    }

    static int count(int[] arr, int l, int r) {
        int res = 0;
        if (l < r) {
            int m = (r + l) / 2;

            // count inversions in left and right
            res += count(arr, l, m);
            res += count(arr, m + 1, r);

            // Count inversions such that big in left and small in right half
            res += merge(arr, l, m, r);
        }
        return res;
    }

    static int inversionCount(int arr[]) {
        return count(arr, 0, arr.length - 1);
    }
}
