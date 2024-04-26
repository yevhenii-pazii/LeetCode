package problem;

class P367 {

    /*
        Time Complexity O(log N)
        Space Complexity O(1)

        46_340 is a last number square of which will fit into integer
     */
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = Math.min(num, 46_340);

        while (lo <= hi) {
            var index = lo + (hi - lo) / 2;

            var square = index * index;

            if (square == num) {
                return true;
            }

            if (square > num) {
                hi = index - 1;
            } else {
                lo = index + 1;
            }

        }

        return false;
    }
}
