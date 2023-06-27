package problem;

public class P278 {

    private final int firstBadVersion;

    public P278(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    /*
        Time Complexity O(log N)
        Space Complexity O(1)

        This is improved version of BS to have lo = hi after the execution
     */
    public int firstBadVersionBinarySearch(int n) {
        int start = 0, end = n, firstBad = Integer.MAX_VALUE;

        while (end >= start) {
            var middle = start + (end - start) / 2;
            if (isBadVersion(middle)) {
                firstBad = Math.min(firstBad, middle);
                end = middle - 1; //move left
            } else {
                start = middle + 1; // move right
            }
        }

        return firstBad;
    }


    /*
        Time Complexity O(log N)
        Space Complexity O(1)

        This is improved version of BS to have lo = hi after the execution
     */
    public int firstBadVersionBinarySearchTemplate2(int n) {
        int lo = 0, hi = n;
        while (lo < hi) {
            //var index = lo + (hi - lo) / 2;
            var index = (lo + hi) >>> 1;

            if (isBadVersion(index)) {
                hi = index;
            } else {
                lo = index + 1;
            }

        }

        return lo;
    }


}
