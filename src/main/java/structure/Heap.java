package structure;

import lombok.ToString;

/*
    TODO create Max Heap
    TODO Generic Heap
 */
@ToString
public class Heap {

    private final int[] heap;

    public Heap(int length) {
        heap = new int[length + 1];
    }

    public Heap(int[] array) {
        this(array, array.length);
    }

    /**
     * Time Complexity O(N)
     * @param array input
     * @param length length of resulting heap
     */
    public Heap(int[] array, int length) {
        heap = new int[length + 1];

        int index = 0;
        int current;
        while (index < array.length && index < length) {
            current = array[index];
            heap[++index] = current;
            heap[0]++;
        }
        heapify();
    }

    public int size() {
        return heap[0];
    }

    public int capacity() {
        return heap.length;
    }

    /**
     * Time Complexity O(1)
     * @return min element
     */
    public int inspect() {
        if (heap[0] > 0) {
            return heap[1];
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Time Complexity O(logN)
     * @return min element
     */
    public int delete() {
        if (heap[0] > 0) {
            var head = heap[1];
            heap[1] = heap[heap[0]--];
            heapifyDown(1);

            return head;
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Time Complexity O(logN)
     * @param element insert element
     */
    public void insert(int element) {
        if (heap[0] < heap.length) {
            heap[++heap[0]] = element;
            heapifyUp();
        } else {
            throw new IllegalStateException();
        }
    }

    private void heapify() {
        int nonLeafIndex = heap[0] / 2;

        while (nonLeafIndex > 0) {
            heapifyDown(nonLeafIndex--);
        }
    }

    private void heapifyDown(int index) {
        var current = heap[index];
        int left = index * 2;
        int right = left + 1;

        while (index <= heap[0] / 2 && // index is not leaf
            (current > heap[left] || (right <= heap[0] && current > heap[right]))) { //min

            if (right <= heap[0] && heap[right] < heap[left]) { //swap right
                heap[index] = heap[right];
                heap[right] = current;
                index = right;
            } else { //swap left
                heap[index] = heap[left];
                heap[left] = current;
                index = left;
            }

            left = index * 2;
            right = left + 1;

        }
    }

    private void heapifyUp() {
        var index = heap[0];
        int parent = index / 2;
        var current = heap[index];

        while (index > 1 && current < heap[parent]) {
            heap[index] = heap[parent];
            heap[parent] = current;
            index = parent;
            parent = index / 2;
        }
    }

}
