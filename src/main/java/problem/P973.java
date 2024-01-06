package problem;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class P973 {

    static class Entry implements Map.Entry<Integer, int[]> {
        private final Integer key;
        private int[] value;

        public Entry(Integer key, int[] value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Integer getKey() {
            return key;
        }

        @Override
        public int[] getValue() {
            return value;
        }

        @Override
        public int[] setValue(int[] value) {
            return this.value = value;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        return null;
    }

    /*
        Time Complexity O(N * Log K)
        Space Complexity O(K)
     */
    public int[][] kClosestMaxHeap(int[][] points, int k) {
        Queue<Map.Entry<Integer, int[]>> maxHeap = new PriorityQueue<>(k, Map.Entry.comparingByKey(Comparator.reverseOrder()));

        for (int[] point : points) {
            var entry = new Entry(point[0] * point[0] + point[1] * point[1], point);

            if (maxHeap.size() == k) {
                if (maxHeap.peek().getKey() > entry.key) {
                    maxHeap.remove();
                    maxHeap.add(entry);
                }
            } else {
                maxHeap.add(entry);
            }
        }

        int[][] result = new int[k][];

        for (var i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.remove().getValue();
        }

        return result;
    }

    //TODO review sorting alg and Divide and Conquer
}
