package problem.p0000_0099;

class P70 {

    /*
        Dynamic programing
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int climbStairs(int n) {
        if (n < 2) return n;
        var combinations = new int[n];
        combinations[0] = 1;
        combinations[1] = 2;

        for (int i = 2; i < n; i++) {
            combinations[i] = combinations[i - 1] + combinations[i - 2];
        }

        return combinations[n - 1];
    }

    /*
        Math
        Time Complexity O(N)
        Space Complexity O(1)
    */
    public int climbStairsFlat(int n) {
        if (n < 2) return n;
        int previous = 1, current = 2, temp;
        for (; n > 2; n--) {
            temp = current;
            current = current + previous;
            previous = temp;
        }

        return current;
    }

    /*
        Pure recursion
        Time Complexity O(2^N)
        Space Complexity O(2^N)
     */
    public int climbStairsRecursion(int n) {
        if (n == 1 || n == 2) return n;
        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
    }

    /*
        Recursion with memorization
        Time Complexity O(N)
        Space Complexity O(N)
    */
    public int climbStairsRecursionWithMemorization(int n) {
        if (n < 3) return n;
        var memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        return recursionWithMemorization(memo, n);
    }

    private int recursionWithMemorization(int[] memo, int n) {
        if (memo[n] == 0) {
            memo[n] = recursionWithMemorization(memo, n - 1) + recursionWithMemorization(memo, n - 2);
        }
        return memo[n];
    }
}
