package problem;

public class P704 {

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (end >= start) {
            var middle = (end - start) / 2 + start;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] > target) {
                end = middle - 1;
            } else  {
                start = middle + 1;
            }
        }

        return -1;
    }


    /*
        The same implementation, but want to try again
        Time complexity O(log N)
        Space complexity O(1)
     */
    public int search2(int[] nums, int target) {
        var hi = nums.length - 1;
        var lo = 0;

        var index = 0;
        while (lo <= hi) {
            index = lo + (hi - lo) / 2; // +1?

            if (nums[index] == target) return index;
            if (nums[index] > target) {
                hi = index - 1;
            } else {
                lo = index + 1;
            }

        }

        return -1;
    }
}
