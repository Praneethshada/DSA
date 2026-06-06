class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer majority1 = 0;
        Integer majority2 = 0;
        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if (num == majority1) {
                c1++;
            } else if (num == majority2) {
                c2++;
            } else if (c1 == 0) {
                majority1 = num;
                c1++;
            } else if (c2 == 0) {
                majority2 = num;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;

        for (int num : nums) {
            if (num == majority1) {
                c1++;
            } else if (num == majority2) {
                c2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        if (c1 > n / 3) {
            res.add(majority1);
        }
        if (c2 > n / 3) {
            res.add(majority2);
        }

        return res;
    }
}