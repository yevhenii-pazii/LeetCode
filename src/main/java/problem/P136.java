package problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P136 {

    /*
        Time Complexity O(N * N)
        Space Complexity O(1)
     */
    public int singleNumberBruteForce(int[] nums) {
        MAIN:
        for (var i = 0; i < nums.length - 1; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                for (var j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        nums[j] = Integer.MIN_VALUE;
                        continue MAIN;
                    }
                }
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    /*
        Time Complexity O(log N) - depends on HashSet -> HashMap implementation
        Space Complexity O(N)
    */
    public int singleNumberSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }

        return set.stream().findFirst().get();
    }

    /*
        Time Complexity O(N * log N)
        Space Complexity O(1)
     */
    public int singleNumberSorting(int[] nums) {
        Arrays.sort(nums);

        for (var i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int singleNumberXor(int[] nums) {
        var result = 0;
        for (var n : nums) {
            result ^= n;
        }
        return result;
    }
}
