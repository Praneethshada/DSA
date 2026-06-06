class Solution {
    void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }
        while (left <= mid) {
            temp.add(nums[left++]);
        }
        while (right <= high) {
            temp.add(nums[right++]);
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    int count(int[] nums, int low, int mid, int high) {
        int c = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && ((long) nums[i] > 2L * nums[right])) {
                right++;
            }
            c += (right - (mid + 1));
        }
        return c;
    }

    int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int c = mergeSort(nums, low, mid);
        c += mergeSort(nums, mid + 1, high);
        c += count(nums, low, mid, high);
        merge(nums, low, mid, high);
        return c;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}