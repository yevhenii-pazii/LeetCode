package problem.p0200_0299;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class P215 {

    /*
        Time Complexity O(N * log N)
        Space Complexity O(1)
     */
    public int findKthLargestBruteForce(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    /*
        Time Complexity O(N * log N + K)
        Space Complexity O(N)
    */
    public int findKthLargestPriorityQueue(int[] nums, int k) {
        Queue<Integer> queue;
        if (k - 1 < nums.length - k + 1) {
            queue = new PriorityQueue<>(k, Comparator.reverseOrder());

        } else {
            k = nums.length - k + 1;
            queue = new PriorityQueue<>(k);
        }

        for (var n : nums) {
            queue.add(n);
        }

        int result = 0;
        while (k != 0) {
            k--;
            result = queue.poll();
        }

        return result;
    }

    /*
        Time Complexity O(N * log K)
        Space Complexity O(K)
     */
    public int findKthLargestPriorityQueueV2(int[] nums, int k) {
        PriorityQueue<Integer> queue;
        boolean findMin;

        if (k - 1 < nums.length - k + 1) {
            queue = new PriorityQueue<>(k);
            findMin = true;
        } else {
            k = nums.length - k + 1;
            queue = new PriorityQueue<>(k, Comparator.reverseOrder());
            findMin = false;
        }

        for (var n : nums) {
            if (queue.size() < k) {
                queue.add(n);
            } else {
                if ((findMin && n > queue.peek()) || (!findMin && n < queue.peek())) {
                    queue.poll();
                    queue.add(n);
                }
            }
        }

        return queue.peek();
    }

    /*
        Time Complexity O(2 * N + M) fastest
        Space Complexity O(M)
     */
    public int findKthLargestCountingSort(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (var n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int[] count = new int[max - min + 1];
        for (var n : nums) {
            count[n - min]++;
        }

        for (var i = count.length - 1; i >= 0 ; i--) {
            k -= count[i];
            if (k <= 0) {
                return i + min;
            }
        }

        return -1;
    }

    //TODO QuickSelect
}
