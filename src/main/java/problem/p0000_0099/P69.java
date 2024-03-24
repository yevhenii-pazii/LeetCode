package problem.p0000_0099;

class P69 {

    /*
        Time Complexity O(1) since number of operation doesn't depend on number
        Space Complexity O(1)

        hi is calculated as (int) Math.sqrt(Integer.MAX_VALUE)
        (hi + 1)^2 is negative

     */
    public int mySqrt(int x) {
        int lo = 0, hi = 46340;

        var sqrt = 0;
        while (lo <= hi) {
            sqrt = lo + (hi - lo) / 2;

            var power = sqrt * sqrt;

            if (power == x)
                return sqrt;
            if (power > x) {
                hi = sqrt - 1;
            } else {
                lo = sqrt + 1;
            }

        }

        return lo - 1;
    }
}
