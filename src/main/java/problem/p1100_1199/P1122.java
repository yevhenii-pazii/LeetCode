package problem.p1100_1199;

import java.util.Map;
import java.util.TreeMap;

class P1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        return null;
    }

    /*
        Time Complexity O(N + M) 100%
        Space Complexity O(N + C) 84.05% C - counts
     */
    public int[] relativeSortArrayCountingArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];

        for (int value : arr1) {
            counts[value]++;
        }

        int i = 0;
        for (int num : arr2) {
            while (counts[num] != 0) {
                arr1[i] = num;
                i++;
                counts[num]--;
            }
        }

        for (int j = 0; j < counts.length; j++) {
            while (counts[j] != 0) {
                arr1[i] = j;
                i++;
                counts[j]--;
            }
        }

        return arr1;
    }

    /*
        Time Complexity O(N * Log N + M) 44.47% Log N - put to Tree Map
     */
    public int[] relativeSortArrayCountingMap(int[] arr1, int[] arr2) {
        Map<Integer, Integer> counts = new TreeMap<>();

        for (int num : arr1) {
            counts.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        int i = 0;
        for (int num : arr2) {
            while (counts.containsKey((Integer) num)) {
                arr1[i] = num;
                i++;
                counts.compute(num, (k, v) -> v == 1 ? null : --v);
            }
        }

        for (var entry : counts.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                arr1[i] = entry.getKey();
                i++;
            }
        }

        return arr1;
    }

}
