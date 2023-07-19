package problem;

import java.util.PriorityQueue;
import java.util.Queue;

public class P703 {

    /*
        Time Complexity O(N log(N)+ M⋅log(k)) first part is initialization, second M add operations
        Space Complexity O(K)
     */
    static class KthLargest {

        private final int k;
        private final Queue<Integer> queue;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>(k + 1); //hold extra one to simplify add() method
            for (var n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            queue.add(val);
            if (queue.size() > k) {
                queue.remove();
            }

            return queue.peek();
        }
    }
}
