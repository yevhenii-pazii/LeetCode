package problem;

import java.util.Arrays;

public class P706 {

    /*
        Time Complexity O(K)
        Space Complexity O(K)

        K is 1_000_001
     */
    static class MyHashMap {

        private final int[] map = new int[1_000_001];

        public MyHashMap() {
            Arrays.fill(map, -1);
        }

        public void put(int key, int value) {
            map[key] = value;
        }

        public int get(int key) {
            return map[key];
        }

        public void remove(int key) {
            map[key] = -1;
        }
    }

     /*
        TODO: also need to implement real hashing with buckets as linked lists and Binary tree
     */
}
