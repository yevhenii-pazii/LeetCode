package problem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        return null;
    }

    /*
        Time Complexity O(M * N + M * log K)
        Space Complexity O(K)

        M - mat.length
        N - mat[].length

        Row Score = sum of solders * 100 + row index
        100 - since the max index of array could be 99 by constraints

        if row has index 99 but o solders score would be 99,
        and 0 index row with a single solder will be 100,
        if row 1 has single solder score will be 101
        so that it is easy to find the sequence
     */
    public int[] kWeakestRowsPriorityQueue(int[][] mat, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k + 1, Comparator.reverseOrder());

        for (var i = 0; i < mat.length; i++) {
            var rowScore = 0;
            for (var j = 0; j < mat[i].length; j++) {
                rowScore += mat[i][j];
            }

            rowScore *= 100;
            rowScore += i;

            queue.add(rowScore);
            if (queue.size() > k) {
                queue.remove();
            }
        }

        int[] result = new int[k];
        for (var i = k - 1; i >= 0; i--) {
            result[i] = queue.remove() % 100;
        }

        return result;
    }

    /*
        Time Complexity O(M * N + M * log K)
        Space Complexity O(K)

        M - mat.length
        N - mat[].length

        Row Score = sum of solders * 100 + row index
        100 - since the max index of array could be 99 by constraints

        if row has index 99 but o solders score would be 99,
        and 0 index row with a single solder will be 100,
        if row 1 has single solder score will be 101
        so that it is easy to find the sequence
     */
    public int[] kWeakestRowsMaxHeap(int[][] mat, int k) {
        var heap = new MaxHeap(k + 1);

        for (var i = 0; i < mat.length; i++) {
            var rowScore = 0;
            for (var j = 0; j < mat[i].length; j++) {
                rowScore += mat[i][j];
            }

            rowScore *= 100;
            rowScore += i;

            heap.add(rowScore);
            if (heap.length() > k) {
                heap.remove();
            }
        }

        int[] result = new int[k];
        for (var i = k - 1; i >= 0; i--) {
            result[i] = heap.remove() % 100;
        }
        return result;
    }

    /*
        Time Complexity O(M * log N + M * log K)
        Space Complexity O(K)

        M - mat.length
        N - mat[].length

        Row Score = sum of solders * 100 + row index
        100 - since the max index of array could be 99 by constraints

        if row has index 99 but o solders score would be 99,
        and 0 index row with a single solder will be 100,
        if row 1 has single solder score will be 101
        so that it is easy to find the sequence
     */
    public int[] kWeakestRowsMaxHeapAndBinarySearch(int[][] mat, int k) {
        var heap = new MaxHeap(k + 1);

        for (var i = 0; i < mat.length; i++) {
            int lo = 0, hi = mat[i].length - 1; //binary search
            while (lo < hi) {
                var index = lo + (hi - lo) / 2;

                if (mat[i][index] == 1) {
                    lo = index + 1;
                } else {
                    hi = index;
                }
            }

            if (mat[i][lo] == 1) {
                lo++;
            }

            heap.add(lo * 100 + i);
            if (heap.length() > k) {
                heap.remove();
            }
        }

        int[] result = new int[k];
        for (var i = k - 1; i >= 0; i--) {
            result[i] = heap.remove() % 100;
        }
        return result;
    }

    private static class MaxHeap {
        private final int[] array;
        private int length = 0;

        MaxHeap(int capacity) {
            array = new int[capacity + 1];
        }

        public int length() {
            return length;
        }

        void add(int value) {
            array[++length] = value;
            var i = length;
            while (i > 1) {
                var parentIndex = i / 2;

                if (array[parentIndex] < value) {
                    array[i] = array[parentIndex];
                    array[parentIndex] = value;
                    i = parentIndex;
                } else {
                    i = 1;
                }
            }
        }

        int remove() {
            var result = array[1];

            array[1] = array[length--];
            var i = 1;
            while (i <= length / 2) { //while not leaf
                var node = array[i];
                var leftIndex = i * 2;

                if (array[leftIndex] > node) {
                    var rightIndex = leftIndex + 1;
                    if (rightIndex <= length && array[rightIndex] > array[leftIndex]) {
                        array[i] = array[rightIndex];
                        array[rightIndex] = node;
                        i = rightIndex;
                    } else {
                        array[i] = array[leftIndex];
                        array[leftIndex] = node;
                        i = leftIndex;
                    }
                } else {
                    var rightIndex = leftIndex + 1;
                    if (rightIndex <= length && array[rightIndex] > node) {
                        array[i] = array[rightIndex];
                        array[rightIndex] = node;
                        i = rightIndex;
                    } else {
                        i = length; // exit
                    }
                }

            }

            return result;
        }
    }

    //TODO Vertical iteration
}
