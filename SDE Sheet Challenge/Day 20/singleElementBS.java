class Solution {
    public int bs(int ar[], int n) {
        int l = 1;
        int h = n - 2;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (ar[m] != ar[m - 1] && ar[m] != ar[m + 1]) {
                return ar[m];
            } else if ((m % 2 == 0 && ar[m] == ar[m + 1]) || (m % 2 == 1 && ar[m] == ar[m - 1])) {
                l = m + 1;
            } else if ((m % 2 == 0 && ar[m] == ar[m - 1]) || (m % 2 == 1 && ar[m] == ar[m + 1])) {
                h = m - 1;
            }
        }
        return 0;
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        return bs(nums, nums.length);
    }
}