package problem;

import java.util.ArrayList;
import java.util.List;

public class P170 {

    //TODO HashSet Solution

    /*
        Time Complexity
            Inset O(LOG N)
            Search O(N)

         Space Complexity O(N)
     */
    static class TwoSumSortedAndTwoPointers {

        private final List<Integer> items = new ArrayList<>();

        public TwoSumSortedAndTwoPointers() {

        }

        public void add(int number) {
            if (items.isEmpty()) {
                items.add(number);
            } else {
                items.add(findIndex(number), number);
            }
        }

        private int findIndex(int number) {
            int start = 0, end = items.size() - 1;

            while (start <= end) {
                var index = (end - start) / 2 + start;
                var current = items.get(index);

                if (number == current) {
                    return index;
                } else if (number < current) {
                    end = index - 1;
                } else {
                    start = index + 1;
                }

            }

            return start;
        }

        public boolean find(int value) {
            int start = 0, end = items.size() - 1;

            while (start < end) {
                int sum = items.get(start) + items.get(end);
                if (sum == value) {
                    return true;
                } else if (sum > value) {
                    end--;
                } else {
                    start++;
                }
            }
            return false;
        }
    }
}
