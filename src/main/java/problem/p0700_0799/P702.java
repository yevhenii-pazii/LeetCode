package problem.p0700_0799;

class P702 {

    static class ArrayReader {

        private final int[] array;


        public ArrayReader(int[] array) {
            this.array = array;
        }

        public int get(int index) {
            if (index >= array.length) {
                return Integer.MAX_VALUE;
            } else {
                return array[index];
            }
        }
    }

    static class Solution {

        /*
            Binary Search
            Time Complexity O(log N)
            Space Complexity O(1)

            N = 10_000
         */
        public int search(ArrayReader reader, int target) {
            int lo = 0, hi = 10_000; //by constraints

            while (lo <= hi) {
                var index = lo + (hi - lo) / 2;
                var current = reader.get(index);

                if (current == target) {
                    return index;
                }

                if (current > target) {
                    hi = index - 1;
                } else {
                    lo = index + 1;
                }

            }

            return -1;
        }
    }
}
