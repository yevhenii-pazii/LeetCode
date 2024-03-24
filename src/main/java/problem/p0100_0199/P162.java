package problem.p0100_0199;

class P162 {

    /*
        Brute Force
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int findPeakElement(int[] nums) {
        var max = Integer.MIN_VALUE;
        var maxIndex = -1;

        for (var i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    /*
        Time Complexity O(log N)
        Space Complexity O(1)
     */
    public int findPeakElementBinarySearch(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            var index = lo + (hi - lo) / 2;

            if (nums[index] < nums[index + 1]) {
                lo = index + 1;
            } else {
                hi = index;
            }
        }

        return lo;
    }

}
