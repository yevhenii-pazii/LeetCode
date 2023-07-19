package problem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P347 {

    /*
        Time Complexity O(N * log N)
        Space Complexity O(N + N)
     */
    public int[] topKFrequentMapAndPriorityQueue(int[] nums, int k) {
        if (k == nums.length) { //all of them are unique
            return nums;
        }


        Map<Integer, Integer> count = new HashMap<>();
        for (var n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n2) - count.get(n1));
        for (var n : count.keySet()) {
            heap.offer(n);
        }


        int[] result = new int[k];
        for (var i = 0; i < k; i++) {
            result[i] = heap.remove();
        }

        return result;
    }


    /*
        Time Complexity O(N * log N)
        Space Complexity O(N + K)
    */
    public int[] topKFrequentMapAndPriorityQueueV2(int[] nums, int k) {
        if (k == nums.length) { //all of them are unique
            return nums;
        }


        Map<Integer, Integer> count = new HashMap<>();
        for (var n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (var n : count.keySet()) {
            heap.offer(n);
            if (heap.size() > k) {  // This transforms (N * log N) complexity to (N * Log K)
                heap.remove();
            }
        }


        int[] result = new int[k];
        for (var i = 0; i < k; i++) {
            result[i] = heap.remove();
        }

        return result;
    }

    //TODO Approach 2: QuickSelect (Hoare's selection algorithm)
}
