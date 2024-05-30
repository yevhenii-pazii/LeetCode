package problem.p0200_0299;

import java.util.Comparator;
import java.util.PriorityQueue;

class P295 {

    static class Default {
        static class MedianFinder {

            public MedianFinder() {

            }

            public void addNum(int num) {

            }

            public double findMedian() {
                return 0.0;
            }
        }
    }

    /*
        Time Complexity  87.74% O(Log N) add and O(1) median
        Space Complexity O(N) 35.08 %
     */
    static class TwoHeaps {
        static class MedianFinder {
            private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();


            public MedianFinder() {

            }

            public void addNum(int num) {
                if (maxHeap.size() == minHeap.size()) { //add mo max / left side
                    if (minHeap.isEmpty() || num <= minHeap.peek()) { //ok to add to max heap
                        maxHeap.add(num);
                    } else {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(num);
                    }
                } else { //add to min / right side
                    if (num >= maxHeap.peek()) {
                        minHeap.add(num);
                    } else {
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(num);
                    }
                }

            }

            public double findMedian() {
                if (maxHeap.size() == minHeap.size()) {
                    return (maxHeap.peek() + minHeap.peek()) / 2.0;
                } else {
                    return maxHeap.peek();
                }
            }
        }
    }


    //TODO sorting

}
