public class P278 {

    private final int firstBadVersion;

    public P278(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }

    public int firstBadVersion(int n) {
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


    public static void main(String[] args) {
        System.out.println(new P278(5).firstBadVersion(1000));
    }
}
