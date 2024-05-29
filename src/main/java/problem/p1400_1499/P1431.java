package problem.p1400_1499;

import java.util.ArrayList;
import java.util.List;

class P1431 {

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        var max = candies[0];
        for (var i = 1; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        List<Boolean> result = new ArrayList<>(candies.length);
        for (var candy: candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}
