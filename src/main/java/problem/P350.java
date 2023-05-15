package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P350 {

    /*
        Time Complexity O(N1 + N2)
        Space Complexity O(R) + O(1001) ~ O(R)
     */
    public int[] intersectCounting(int[] nums1, int[] nums2) {
        var count = new int[1001];

        for (int n : nums1) {
            count[n]++;
        }

        List<Integer> intersection = new ArrayList<>();
        for (var n : nums2) {
            if (count[n] > 0) {
                intersection.add(n);
                count[n]--;
            }
        }

        var result = new int[intersection.size()];
        for (var i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }

    /*
        Time Complexity O(N1 + N2)
        Space Complexity O(R) + O(1001) ~ O(R)
     */
    public int[] intersectMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums1) {
            count.compute(n, (k, v) -> v == null ? 1 : v + 1);
        }

        List<Integer> intersection = new ArrayList<>();
        for (var n : nums2) {
            if (count.containsKey(n)) {
                intersection.add(n);
                count.compute(n, (k, v) -> v == 1 ? null : v - 1);
            }
        }

        var result = new int[intersection.size()];
        for (var i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }

    /*
        Time Complexity O()
        Space Complexity O()

        TODO
     */
    public int[] intersectTwoPointers(int[] nums1, int[] nums2) {
        return null;
    }

    /*
        Time Complexity O(N1 + N2) ??
        Space Complexity O(N1 + N2)
     */
    public int[] intersectList(int[] nums1, int[] nums2) {
        List<Integer> l1 = new ArrayList<>(nums1.length);
        List<Integer> l2 = new ArrayList<>(nums2.length);

        for (var n : nums1) {
            l1.add(n);
        }
        for (var n : nums2) {
            l2.add(n);
        }

        l1.retainAll(l2);

        return l1.stream().mapToInt(Integer::intValue).toArray(); // or use loop
    }
}
