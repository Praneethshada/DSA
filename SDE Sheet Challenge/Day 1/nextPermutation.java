class Solution {
    public void rev(int[] ar, int s, int e) {
        while (s <= e) {
            int x = ar[s];
            ar[s] = ar[e];
            ar[e] = x;
            s++;
            e--;
        }
    }

    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            rev(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[idx]) {
                int x = nums[i];
                nums[i] = nums[idx];
                nums[idx] = x;
                break;
            }
        }

        rev(nums, idx + 1, n - 1);
        return;
    }
}