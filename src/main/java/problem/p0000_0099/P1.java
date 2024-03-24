package problem.p0000_0099;

import java.util.HashMap;
import java.util.Map;

class P1 {

    /*
        My Solution.

        Time Complexity O(N + K)
        Space Complexity O(K) Constant memory, but works well only on the large amount of data.

        K is number of data range
     */
    public int[] twoSumWithArrayAsMap(int[] nums, int target) {
        int index0, index1;

        int shift = 1_000_000_000;
        int[] hash = new int[2 * shift]; // Key - number, value - index in nums

        for (var i = 0; i < nums.length; i++) {
            hash[nums[i] + shift] = i;
        }

        for (var i = 0; i < nums.length - 1; i++) {
            index0 = i;
            int numberToFind = target - nums[i];
            index1 = hash[numberToFind + shift];

            if (index1 > 0 && index1 != index0) {
                return new int[]{index0, index1};
            }
        }
        return null;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int[] twoSumWithMapTwoPass(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>(nums.length);
        for (var i = 0; i < nums.length; i++) {
            table.put(nums[i], i);
        }

        for (var i = 0; i < nums.length - 1; i++) {
            int numberToFind = target - nums[i];
            if (table.containsKey(numberToFind)) {
                int index2 = table.get(numberToFind);
                if (i != index2) {
                    return new int[]{i, index2};
                }
            }
        }

        return null;
    }

    /*
       Time Complexity O(N), but better than Two Pass
       Space Complexity O(N)
    */
    public int[] twoSumWithMapSinglePass(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>(nums.length);

        for (var i = 0; i < nums.length; i++) {
            var numberToFind = target - nums[i];
            if (table.containsKey(numberToFind)) {
                return new int[]{table.get(numberToFind), i};
            } else {
                table.put(nums[i], i);
            }
        }

        return null;
    }
}
