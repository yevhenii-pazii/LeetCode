package problem.p0200_0299;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class P219 {

    /*
        Time Complexity O(N * N)
        Space Complexity O(1)
     */
    public boolean containsNearbyDuplicateSlidingWindow(int[] nums, int k) {
        for (var i = 0; i < nums.length; i++) {
            for (var j = i + 1; j < nums.length  && j <= i + k; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }

        return false;
    }

   /*
        Time Complexity O(N)
        Space Complexity O(min(N, K))
    */
    public boolean containsNearbyDuplicateSlidingWindowWithSet(int[] nums, int k) {
        Set<Integer> window = new HashSet<>(k + 1);

        for (var i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }

            window.add(nums[i]);

            if (window.size() > k) {
                window.remove(nums[i - k]);
            }

        }

        return false;
    }


    /*
        Time Complexity O(N)
        Space Complexity O(N)
    */
    public boolean containsNearbyDuplicateMap(int[] nums, int k) {
        Map<Integer, Integer> lastOccurrence = new HashMap<>();

        for (var i = 0; i < nums.length; i++) {
            var num = nums[i];

            if (lastOccurrence.containsKey(num) && i - lastOccurrence.get(num) <= k) {
                return true;
            }
            lastOccurrence.put(num, i);
        }

        return false;
    }
}
