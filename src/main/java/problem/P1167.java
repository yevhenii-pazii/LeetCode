package problem;

import java.util.PriorityQueue;
import java.util.Queue;

class P1167 {

    public int connectSticks(int[] sticks) {
        return 0;
    }

    /*
        Time Complexity O(N Log N + N)
        Space Complexity O(N)
     */
    public int connectSticksPriorityQueue(int[] sticks) {
        Queue<Integer> minHeap = new PriorityQueue<>(sticks.length);

        for (var stick : sticks) {
            minHeap.add(stick);
        }

        var cost = 0;

        while (minHeap.size() > 1) {
            int sum = minHeap.poll() + minHeap.poll();
            cost += sum;
            minHeap.add(sum);
        }

        return cost;
    }

    /*
        Time Complexity O(N + N)
        Space Complexity O(N)
    */
    public int connectSticksArrayHeap(int[] sticks) {
        var cost = 0;
        var length = sticks.length;

        heapify(sticks, length);

        while (length > 1) {
            var sum = remove(sticks, length--) + remove(sticks, length--);
            cost += sum;
            add(sticks, length++, sum);
        }

        return cost;
    }

    private void heapify(int[] array, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapifyDown(array, length, i);
        }

    }

    private void heapifyDown(int[] array, int length, int index) {
        if (index >= length / 2) {
            return;
        }

        var leftLeaf = index * 2  + 1;
        var rightLeaf = index * 2 + 2;

        if (rightLeaf < length) {

            if(array[index] > array[leftLeaf] || array[index] > array[rightLeaf]) {
                var temp = array[index];
                if (array[leftLeaf] < array[rightLeaf]) {
                    array[index] = array[leftLeaf];
                    array[leftLeaf] = temp;

                    heapifyDown(array, length, leftLeaf);
                } else {
                    array[index] = array[rightLeaf];
                    array[rightLeaf] = temp;

                    heapifyDown(array, length, rightLeaf);
                }
            }

        } else {

            if (array[index] > array[leftLeaf]) {
                var temp = array[index];
                array[index] = array[leftLeaf];
                array[leftLeaf] = temp;

                heapifyDown(array, length, leftLeaf);
            }
        }
    }

    private int remove(int[] array, int length) {
        var result = array[0];
        array[0] = array[length - 1];
        heapifyDown(array, length - 1, 0);
        return result;
    }

    private void add(int[] array, int length, int num) {
        array[length] = num;
        var index = length;
        var parent = (index - 1) / 2;
        while (index > 0 && num < array[parent]) {
            array[index] = array[parent];
            array[parent] = num;
            index = parent;
            parent = (index - 1) / 2;
        }
    }
}
