package problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class P154 {

    public int findMin(int[] nums) {
        return 0;
    }

    /*
        Time Complexity O(log N) on average, O(N) worst
        Space Complexity O(N)
     */
    public int findMinBinarySearch(int[] nums) {
        var min = Integer.MAX_VALUE;

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, nums.length - 1});

        while (!stack.isEmpty()) {
            var range = stack.pop();
            int lo = range[0], hi = range[1];

            while (lo < hi) {
                var index = lo + (hi - lo) / 2;

                if (nums[lo] < nums[index] || lo == index) { // left side is linear

                    if (nums[index] <= nums[hi]) { // right side is linear
                        hi = index;
                    } else { // right side is not linear;
                        lo = index + 1;
                    }
                } else {

                    if (nums[index] > nums[hi]) { // right side is not linear
                        lo = index + 1;
                    } else { //
                        if (nums[lo] == nums[index] && nums[index] == nums[hi]) {
                            stack.push(new int[]{index + 1, hi});
                        }
                        hi = index;
                    }
                }
            }

            min = Math.min(min, nums[lo]);
        }

        return min;
    }

    /*
        Time Complexity O(log N) on average, O(N) worst
        Space Complexity O(1)
     */
    public int findMinBinarySearch2(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            if (nums[hi] == nums[lo]) {
                hi--;
                continue;
            }

            var index = lo + (hi - lo) / 2;

            if (nums[lo] <= nums[index]) { // left side is linear
                if (nums[index] <= nums[hi]) { // right side is linear as well
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
