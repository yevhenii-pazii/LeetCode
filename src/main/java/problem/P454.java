package problem;

import java.util.HashSet;
import java.util.Set;

public class P454 {

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
    public int fourSumCountSet(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        var count = 0;

        Set<Integer> left = new HashSet<>();

        for (var n1 : nums1) {
            for (var n2 : nums2) {
                left.add(n1 + n2);
            }
        }

        for (var n3 : nums3) {
            for (var n4 : nums4) {
                if (left.contains(-(n3 + n4))) {
                    count++;
                }
            }
        }

        return count;
    }

    // TODO Approach 2: kSum II
}
