package problem.p0_99;

class P33 {

    /*
        Time Complexity O(log N)
        Space Complexity O(1)
     */
    public int searchDoubleBinary(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        var min = Integer.MAX_VALUE;
        var minIndex = -1;
        while (lo <= hi) { // search for the min item it would be our shift
            var index = lo + (hi - lo) / 2;

            if (nums[index] < min) {
                min = nums[index];
                minIndex = index;
            }

            if (nums[index] < nums[hi]) {
                hi = index - 1;
            } else {
                lo = index + 1;
            }

        }

        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) { // find number
            var index = lo + (hi - lo) / 2;
            var shifted = (index + minIndex) % nums.length;

            if (nums[shifted] == target) return shifted;
            if (nums[shifted] < target) {
                lo = index + 1;
            } else {
                hi = index - 1;
            }

        }

        return -1;
    }

    /*
        Time Complexity O(log N)
        Space Complexity O(1)
    */
    public int searchSingleBinary(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            var index = lo + (hi - lo) / 2;

            if (nums[index] == target) return index;

            if (nums[lo] <= nums[index]) { //left side is linear; yes <=
                if (target >= nums[lo] && target < nums[index]) { // is target in linear side
                    hi = index - 1;
                } else {
                    lo = index + 1;
                }
            } else {
                if (target <= nums[hi] && target > nums[index]) { // is target in linear side
                    lo = index + 1;
                } else {
                    hi = index - 1;
                }
            }
        }

        return -1;
    }

}
