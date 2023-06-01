package problem;

public class P622 {

    /*
        Time Complexity O(1) for all operations
        Space Complexity O(K)
     */
    static class MyCircularQueue {

        private final int size;
        private final int[] array;

        private int head = -1;
        private int tail = 0;

        public MyCircularQueue(int k) {
            size = k;
            array = new int[k];
        }

        public boolean enQueue(int value) {
            if (head == tail) return false;

            array[tail] = value;
            tail = (tail + 1) % size;
            if (head == -1) {
                head = 0;
            }

            return true;
        }

        public boolean deQueue() {
            if (head == -1) return false;

            head = (head + 1) % size;
            if (head == tail) {
                head = -1;
                tail = 0;
            }

            return true;
        }

        public int Front() {
            return head == -1 ? head : array[head];
        }

        public int Rear() {
            return head == -1 ? head : array[tail == 0 ? size - 1 : tail - 1];
        }

        public boolean isEmpty() {
            return head == -1;
        }

        public boolean isFull() {
            return head == tail;
        }
    }

    // TODO Linked list implementation (not Collection and Collection)
}
