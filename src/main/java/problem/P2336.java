package problem;

import java.util.SortedSet;
import java.util.TreeSet;

public class P2336 {

    /*
        Here, n is the number addBack(num) and m is the number of popSmallest() method calls.

        Time Complexity O((m+n) * log n)
        Space Complexity O(n)
     */
    static class SmallestInfiniteSet {

        private int smallest = 1;

        /*
            Can use array and use binary search to find please to insert,
            but insertion takes much longer than TreeSet?
         */
        private final SortedSet<Integer> buffer = new TreeSet<>();

        public SmallestInfiniteSet() {

        }

        public int popSmallest() {
            if (!buffer.isEmpty()) {
                var num = buffer.first();
                buffer.remove(num);
                return num;
            } else {
                return smallest++;
            }
        }

        public void addBack(int num) {
            if (num < smallest) {
                buffer.add(num);
            }
        }
    }
}
