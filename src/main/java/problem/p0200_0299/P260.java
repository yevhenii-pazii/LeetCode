package problem.p0200_0299;

import java.util.HashSet;
import java.util.Set;

class P260 {

    public int[] singleNumber(int[] nums) {
        return null;
    }

    /*
        Time Complexity O(N) 33.39%
        Space Complexity O(N) 36.75%
     */
    public int[] singleNumberHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    /* NOT MINE, but super clever
        Time Complexity O(N) 100%
        Space Complexity O(N) 69.87%
     */
    public int[] singleNumberBinary(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask ^ x};
    }

}
