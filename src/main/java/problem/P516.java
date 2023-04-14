package problem;

public class P516 {

    /*
        Fails because of time complexity.
        Time Complexity O(N^2) even more
        Space Complexity O(1)
     */
    public int longestPalindromeSubseqReqursion(String s) {
        return longestPalindromeRecursion(s.toCharArray(), 0, s.length() - 1);
    }

    private int longestPalindromeRecursion(char[] chars, int start, int end) {
        if (end < start) return 0;
        if (start == end) return 1;

        if (chars[start] == chars[end]) return longestPalindromeRecursion(chars, start + 1, end - 1) + 2;

        return Math.max(
                longestPalindromeRecursion(chars, start + 1, end),
                longestPalindromeRecursion(chars, start, end - 1));
    }

    /*
        Recursion with memorization

        Time Complexity O(N^2)
        Space Complexity O(N^2)
     */
    public int longestPalindromeSubseqReqursionWithMemorization(String s) {
        return recursionWithMemorization(
                s.toCharArray(), 0, s.length() - 1, new int[s.length()][s.length()]);
    }

    private int recursionWithMemorization(char[] chars, int start, int end, int[][] memo) {
        if (end < start) return 0;
        if (start == end) return 1;
        if (memo[start][end] != 0) return memo[start][end];

        if (chars[start] == chars[end]) {
            memo[start][end] = recursionWithMemorization(chars, start + 1, end - 1 , memo) + 2;
        } else {
            memo[start][end] = Math.max(
                    recursionWithMemorization(chars, start + 1, end, memo),
                    recursionWithMemorization(chars, start, end - 1, memo));
        }

        return memo[start][end];
    }

    /*
        Iteration with memorization (not mine)

        Time Complexity O(N^2)
        Space Complexity O(N^2)
     */

    public int longestPalindromeSubseqIterativeWithMemorization(String s) {
        var memo = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            memo[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    memo[i][j] = memo[i + 1][j - 1] + 2;
                } else {
                    memo[i][j] = Math.max(memo[i + 1][j], memo[i][j - 1]);
                }
            }
        }

        return memo[0][s.length() - 1];
    }

    //TODO add iterative with space optimization
}
