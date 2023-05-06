package problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P217 {

    /*
        Time Complexity O(N * N)
        Space Complexity O(1)
     */
    public boolean containsDuplicateBruteForce(int[] nums) {
        for (var i = 0; i < nums.length - 1; i++) {
            for (var j = i + 1; j <nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
        Time Complexity O(N * log N)
        Space Complexity O(1)
    */
    public boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);

        for (var i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
    // TODO can try to find duplicates during sorting

    /*
        Exceeds memory limit

        Time Complexity O(K + N) K - to initialize array
        Space Complexity O(K)
     */
    public boolean containsDuplicateArrayAsHashTable(int[] nums) {
        var shift = 1_000_000_000;
        var table = new boolean[2 * shift + 1];

        for (var num : nums) {
            if (table[num + shift]) {
                return true;
            } else {
                table[num + shift] = true;
            }
        }

        return false;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public boolean containsDuplicateHashSet(int[] nums) {
        Set<Integer> table = new HashSet<>();

        for (var num : nums) {
            if (table.contains(num)) {
                return true;
            } else {
                table.add(num);
            }
        }

        return false;
    }

    //TODO own hash set
}
