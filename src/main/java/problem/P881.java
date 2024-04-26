package problem;

import java.util.Arrays;

class P881 {

    /*
        Time Complexity O(N * log N) -> N * log N used for sort + N for final loop -> N * log N
        Space Complexity O(log N) -> log N used for sort
     */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        var boats = 0;

        var lo = 0;
        var hi = people.length - 1;

        while (lo <= hi) {
            if (people[hi] + people[lo] <= limit) {
                lo++;
            }
            boats++;
            hi--;
        }

        return boats;
    }
}
