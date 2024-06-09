package problem.p0900_0999;

import java.util.HashMap;
import java.util.Map;

class P974 {

    public int subarraysDivByK(int[] nums, int k) {
        return 0;
    }

    /*
        Time Complexity O(N) 80.8%
        Space Complexity O(N) 28.93%

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

}
