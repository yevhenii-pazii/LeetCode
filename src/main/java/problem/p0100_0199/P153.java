package problem.p0100_0199;

class P153 {

    /*
        Brute Force
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    /*
        Single Binary search
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int findMinBinarySearch(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            var index = lo + (hi - lo) / 2;

            if (nums[lo] <= nums[index]) { // left side is linear
                if (nums[index] < nums[hi]) { // right side is linear as well
                    hi = index;
                } else {
                    lo = index + 1;
                }
            } else { // left side is not linear
                hi = index;
            }

        }

        return nums[lo];
    }
}
