package problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P349 {

    /*
        Time Complexity O(N * M)
        Space Complexity O(K)
        K - result size
     */
    public int[] intersectionBruteForce(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        for (int n1 : nums1) {
            if (!result.contains(n1)) {
                for (int n2 : nums2) {
                    if (n1 == n2) {
                        result.add(n1);
                        break;
                    }
                }
            }
        }

        var array = new int[result.size()];
        var i = 0;
        for (var n : result) {
            array[i++] = n;
        }

        return array;
    }

    /*
        Time Complexity O(N + M)
        Space Complexity O(N + M)
     */
    public int[] intersectionHashSet(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>(nums1.length);
        for (var n : nums1) {
            nums1Set.add(n);
        }

        Set<Integer> nums2Set = new HashSet<>(nums2.length);
        for (var n : nums2) {
            nums2Set.add(n);
        }

        Set<Integer> result = new HashSet<>();
        Set<Integer> bigger = nums1Set.size() > nums2Set.size() ? nums1Set : nums2Set;
        Set<Integer> smaller = bigger == nums1Set ? nums2Set : nums1Set;
        for (var n : smaller) {
            if (bigger.contains(n)) {
                result.add(n);
            }
        }

        var array = new int[result.size()];
        var i = 0;
        for (var n : result) {
            array[i++] = n;
        }

        return array;
    }

    /*
        Time Complexity O(N + M)
        Space Complexity O(N + M)
     */
    public int[] intersectionHashSetNative(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>(nums1.length);
        for (var n : nums1) {
            nums1Set.add(n);
        }

        Set<Integer> nums2Set = new HashSet<>(nums2.length);
        for (var n : nums2) {
            nums2Set.add(n);
        }

        nums1Set.retainAll(nums2Set);

        var array = new int[nums1Set.size()];
        var i = 0;
        for (var n : nums1Set) {
            array[i++] = n;
        }

        return array;
    }


    /*
        Time Complexity O(N + M)
        Space Complexity O(N + M)
        K - result size
     */
    public int[] intersectionCountingSort(int[] nums1, int[] nums2) {
        var num1Flags = new boolean[1001];
        for (var n : nums1) {
            num1Flags[n] = true;
        }

        var num2Flags = new boolean[1001];
        for (var n : nums2) {
            num2Flags[n] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (var n = 0; n < 1001; n++) {
            if (num1Flags[n] && num2Flags[n]) {
                result.add(n);
            }
        }

        var array = new int[result.size()];
        var i = 0;
        for (var n : result) {
            array[i++] = n;
        }

        return array;
    }
}
