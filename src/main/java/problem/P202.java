package problem;

import java.util.HashSet;
import java.util.Set;

public class P202 {

    /*
        Time Complexity O(log N) why?
        Space Complexity O(log N) the same as Time as we memorize each step
     */
    public boolean isHappyHashSetForMemorization(int n) {
        Set<Integer> processed = new HashSet<>();
        while (n != 1 && !processed.contains(n)) {
            processed.add(n);
            var nn = 0;
            while (n > 0) {
                var current = n % 10;
                nn += current * current;
                n /= 10;
            }
            n = nn;
        }

        return n == 1;
    }

    /*
        Time Complexity O(log N)
        Space Complexity O(1)
     */
    public boolean isHappyFastSlow(int n) {
        var fast = n;
        var slow = n;
        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (fast != 1 && fast != slow);

        return fast == 1;
    }

    private int next(int n) {
        var nn = 0;
        while (n > 0) {
            var current = n % 10;
            nn += current * current;
            n /= 10;
        }
        return nn;
    }
}
