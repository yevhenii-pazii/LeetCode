package problem.p0900_0999;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

class P945 {

    public int minIncrementForUnique(int[] nums) {
        return 0;
    }

    //TODO need to implement didn't have time
    public int minIncrementForUniqueCounting(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.compute(num, (k, v) -> v == null ? 1: v + 1);
        }

        SortedSet<Integer> uniqueNumbers = new TreeSet<>(counts.keySet());

//        uniqueNumbers.
//        for ()

        return 0;
    }

    /*
        Time Complexity O(N Log N) 72.13%
        Space Complexity O(1) 51.48 %
     */
    public int minIncrementForUniqueSorting(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int diff = nums[i - 1] - nums[i] + 1;
                nums[i] += diff;
                result += diff;
            }
        }

        return result;
    }
}
