package problem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class P378 {

    public int kthSmallest(int[][] matrix, int k) {
        return 0;
    }

    /*
        Time Complexity O(L * Log K)
        Space Complexity O(K)

        L = N * N
        K <= L / 2
     */
    public int kthSmallestPriorityQueue(int[][] matrix, int k) {
        var length = matrix.length * matrix.length;
        Queue<Integer> queue;
        if (k > length / 2) {
            // L - K
            k = length - k + 1;
            queue = new PriorityQueue<>(k + 1, Comparator.naturalOrder());
        } else {
            //k
            queue = new PriorityQueue<>(k + 1, Comparator.reverseOrder());
        }

        for (var row : matrix) {
            for (var element: row) {
                queue.add(element);
                if (queue.size() > k) {
                    queue.remove();
                }
            }
        }

        return queue.peek();
    }


    /*
        Time Complexity O(X + K * log(X))
        Space Complexity O(X)
        X=min(K,N)

        heap size -> min of K and N, m[a][0] < m[b][0] if a < b,
            All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
        array -> {value, i, j}
     */
    public int kthSmallestPriorityQueueV2(int[][] matrix, int k) {
        var heapSize = Math.min(k, matrix.length);
        Queue<int[]> queue = new PriorityQueue<>(heapSize, Comparator.comparingInt(array -> array[0]));

        for (var i = 0; i < heapSize; i++) {
            queue.add(new int[]{matrix[i][0], i, 0});
        }

        for (var index = 1; index < k; index++) {
            var smallest = queue.remove();
            if (smallest[2] + 1 < matrix.length) {
                queue.add(new int[]{matrix[smallest[1]][smallest[2] + 1], smallest[1], smallest[2] + 1});
            }
        }

        return queue.peek()[0];
    }

    // TODO Binary search
}
