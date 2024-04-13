package problem.p0400_0499;

import java.util.HashMap;
import java.util.Map;

class P454 {

    /*
        Time Complexity O(N * N * N * N) N^4
        Space Complexity O(1)

        N - elements in one array
     */
    public int fourSumCountBruteForce(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        var length = nums1.length;
        var count = 0;
        var sum = 0;
        for (var i = 0; i < length; i++) {
            sum += nums1[i];
            for (var j = 0; j < length; j++) {
                sum += nums2[j];
                for (var k = 0; k < length; k++) {
                    sum += nums3[k];
                    for (var l = 0; l < length; l++) {
                        sum += nums4[l];
                        if (sum == 0) {
                            count++;
                        }
                        sum -= nums4[l];
                    }
                    sum -= nums3[k];
                }
                sum -= nums2[j];
            }
            sum -= nums1[i];
        }

        return count;
    }

    /*
        Time Complexity O(N * N)
        Space Complexity O(N * N)

        N - elements in one array
     */
    public int fourSumCountHashMap(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        var count = 0;

        Map<Integer, Integer> left = new HashMap<>();

        for (var n1 : nums1) {
            for (var n2 : nums2) {
                //left.compute(n1 + n2, (k, old) -> old == null ? 1 : old + 1);
                left.put(n1 + n2, left.getOrDefault(n1 + n2, 0) + 1);
            }
        }

        for (var n3 : nums3) {
            for (var n4 : nums4) {
                count += left.getOrDefault(-(n3 + n4), 0);
            }
        }

        return count;
    }

    // TODO Approach 2: kSum II
}
