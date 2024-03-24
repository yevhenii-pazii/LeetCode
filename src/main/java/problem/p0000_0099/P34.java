package problem.p0000_0099;

class P34 {

    /*
        Brute Force
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int[] searchRangeBruteForce(int[] nums, int target) {
        int[] result = new int[] {-1, -1};

        var i = 0;
        while (i < nums.length && nums[i] != target) {
            i++;
        }

        if (i < nums.length) {
            result[0] = i;

            while (nums[i] == target) {
                i++;
            }
            result[1] = i - 1;
        }

        return result;
    }

    /*
        Time Complexity O(2 * log N)
        Space Complexity O(1)
    */
    public int[] searchRangeBinarySearch(int[] nums, int target) {
        int[] result = new int[] {-1, -1};

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int index = lo + (hi - lo) / 2;

            if (nums[index] >= target) {
                hi = index;
            } else {
                lo = index + 1;
            }
        }

        if (lo < nums.length && nums[lo] == target) {
            result[0] = lo;

            lo = 0;
            hi = nums.length - 1;

            while (lo < hi) {
                int index = lo + (hi - lo) / 2;

                if (nums[index] <= target) {
                    lo = index + 1;
                } else {
                    hi = index;
                }
            }
            result[1] = nums[lo] == target ? lo : lo -1;
        }

        return result;
    }
}
