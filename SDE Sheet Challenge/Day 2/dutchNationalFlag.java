class Solution {
    public void sortColors(int[] nums) {
        // dutch national flag algo

        // 0 to low-1: All 0s
        // low to mid-1: All 1s
        // mid to high: Unknown values: 0, 1, or 2
        // high+1 to end: All 2s

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (mid <= high) {
            if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 0) {
                nums[mid] = nums[low];
                nums[low] = 0;
                mid++;
                low++;
            } else {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }
    }
}