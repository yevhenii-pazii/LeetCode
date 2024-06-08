package problem.p0500_0599;

class P509 {


    /*
           Time Complexity O(2^N)
           Space Complexity O(N)
     */
    public int fib(int n) {
        if (n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }


    /*
       Time Complexity O(N)
       Space Complexity O(1)
    */
    public int fibFlat(int n) {
        if (n < 2) return n;

        int temp;
        int previous = 0;
        int current = 1;

        for (; n > 1; n--) {
            temp = current;
            current = current + previous;
            previous = temp;
        }
        return current;
    }


    /*
        Time Complexity O(N)
        Space Complexity O(N)
    */
    public int fibRecursionWithMemorization(int n) {
        return memorizationHelper(new int[n + 1], n);
    }

    private int memorizationHelper(int[] memo, int n) {
        if (n < 2) return n;
        if (memo[n] == 0) {
            memo[n] = memorizationHelper(memo, n - 1) + memorizationHelper(memo, n - 2);
        }
        return memo[n];
    }

    /*
        Not mine but super efficient
        Time Complexity O(log N)
        Space Complexity O(1)
     */
    public int fibGoldenRatio(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldenRatio, N) / Math.sqrt(5));
    }

}
