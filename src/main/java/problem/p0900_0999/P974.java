package problem.p0900_0999;

import java.util.HashMap;
import java.util.Map;

class P974 {

    public int subarraysDivByK(int[] nums, int k) {
        return 0;
    }

    /*
        Time Complexity O(N + K) 80.8%
        Space Complexity O(K) 28.93%

        https://en.wikipedia.org/wiki/Triangular_number
     */
    public int subarraysDivByKPrefixSum(int[] nums, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);

        int prefix = 0;
        for (int num : nums) {
            prefix = (prefix + num) % k;

            if (prefix < 0) {
                prefix += k;
            }

            memo.compute(prefix, (key, value) -> value == null ? 1 : value + 1);
        }

        int result = 0;
        for (var entry : memo.entrySet()) {
            result += entry.getValue() * (entry.getValue() - 1) / 2;
        }

        return result;
    }

    /*  Not mine
        Time Complexity O(N + K) 74.54%
        Space Complexity O(K) 21.81%
     */
    public int subarraysDivByKPrefixSumInPlace(int[] nums, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);

        int prefix = 0;
        int result = 0;
        for (int num : nums) {
            prefix = (prefix + num) % k;

            if (prefix < 0) {
                prefix += k;
            }

            result += memo.getOrDefault(prefix, 0);
            memo.compute(prefix, (key, value) -> value == null ? 1 : value + 1);
        }

        return result;
    }

    /*  Not mine
        Time Complexity O(N + K) 89.40%
        Space Complexity O(K) 91.49%
    */
    public int subarraysDivByKPrefixSumInPlaceArray(int[] nums, int k) {
        int[] counts = new int[k];
        counts[0] = 1;

        int prefix = 0;
        int result = 0;
        for (int num : nums) {
            prefix = (prefix + num) % k;

            if (prefix < 0) {
                prefix += k;
            }

            result += counts[prefix];
            counts[prefix]++;
        }

        return result;
    }

}
