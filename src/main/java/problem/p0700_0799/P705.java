package problem.p0700_0799;

class P705 {

    /*
        Time Complexity O(K)
        Space Complexity O(K)

        k is 1_000_001
     */
    static class MyHashSet {

        private final boolean[] set = new boolean[1_000_001];

        public MyHashSet() {

        }

        public void add(int key) {
            set[key] = true;
        }

        public void remove(int key) {
            set[key] = false;
        }

        public boolean contains(int key) {
            return set[key];
        }
    }
    /*
        TODO: also need to implement real hashing with buckets as linked lists and Binary tree
     */
}
