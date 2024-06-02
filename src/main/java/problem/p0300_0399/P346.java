package problem.p0300_0399;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P346 {

    /*
        Time Complexity O(1);
        Space Complexity O(size)
     */
    static class MovingAverageArray {

        private final int[] storage;
        private int index = 0;
        private int count = 0;
        private int sum = 0;

        public MovingAverageArray(int size) {
            storage = new int[size];
        }

        public double next(int val) {
            sum += val;

            if (count >= storage.length) {
                sum -= storage[index];
            } else {
                count++; //increment only if smaller;
            }

            storage[index] = val;

            index = (index + 1) % storage.length;

            return (sum + 0.0) / count;
        }
    }

    /*
        Time Complexity O(1);
        Space Complexity O(size)
    */
    static class MovingAverageLinkedList {

        private final List<Integer> storage = new LinkedList<>();
        private final int size;
        private int sum = 0;

        public MovingAverageLinkedList(int size) {
            this.size = size;
        }

        public double next(int val) {
            sum += val;
            storage.add(val);

            if (storage.size() > size) {
                sum -= storage.remove(0);
            }

            return (sum + 0.0) / storage.size();
        }

    }

    /*
        Time Complexity O(1);
        Space Complexity O(size)
     */
    static class MovingAverageQueue {

        private final Queue<Integer> storage;
        private final int size;
        private int sum = 0;

        public MovingAverageQueue(int size) {
            this.size = size;
            storage = new ArrayDeque<>(size);
        }

        public double next(int val) {
            sum += val;
            storage.add(val);

            if (storage.size() > size) {
                sum -= storage.remove();
            }

            return (sum + 0.0) / storage.size();
        }

    }
}
