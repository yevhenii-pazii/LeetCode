package problem.p0700_0799;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P760 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int[] anagramMappingsHashMap(int[] nums1, int[] nums2) {
        var result = new int[nums2.length];
        Map<Integer, List<Integer>> map = new HashMap<>(nums2.length);

        for (var i = 0; i < nums2.length; i++) {
            map.computeIfAbsent(nums2[i], k -> new ArrayList<>());
            map.get(nums2[i]).add(i);
        }

        for (var i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]).remove(0);
        }

        return result;
    }

    /*
        Time Complexity O(N * Log N)
        Space Complexity O(N + Log N) new arrays and for sorting
     */
    public int[] anagramMappingsSorting(int[] nums1, int[] nums2) {
        var result = new int[nums1.length];

        var num1Indexed = new int[nums1.length][2];
        var num2Indexed = new int[nums1.length][2];

        for (var i = 0; i < nums1.length; i++) {
            num1Indexed[i][0] = nums1[i];
            num1Indexed[i][1] = i;

            num2Indexed[i][0] = nums2[i];
            num2Indexed[i][1] = i;
        }

        Arrays.sort(num1Indexed, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(num2Indexed, Comparator.comparingInt(a -> a[0]));

        for (var i = 0; i < num2Indexed.length; i++) {
            result[num1Indexed[i][1]] = num2Indexed[i][1];
        }

        return result;
    }


    /*
        Not mine

        Time Complexity O(N * Log N)
        Space Complexity O(Log N) used for sorting
     */
    public int[] anagramMappingsBitShiftAndSort(int[] nums1, int[] nums2) {
        final int bitsToShift = 7;
        final int numToGetLastBits = (1 << bitsToShift) - 1;

        // Store the index within the integer itself.
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = (nums1[i] << bitsToShift) + i;
            nums2[i] = (nums2[i] << bitsToShift) + i;
        }

        // Sort both lists so that the original integers end up at the same index.
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // List to store the anagram mappings.
        int[] mappings = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // Store the index in the second list corresponding to the integer index in the first list.
            mappings[nums1[i] & numToGetLastBits] = (nums2[i] & numToGetLastBits);
        }

        return mappings;
    }
}
