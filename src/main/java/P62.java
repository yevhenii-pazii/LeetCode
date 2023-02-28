public class P62 {

    public static void main(String[] args) {
        System.out.println("3 7 -> " + new P62().uniquePathsFlat(3, 7));
    }

    public int uniquePaths(int m, int n) {
        return cal(1, m, 1, n);
    }

    private static int cal(int i, int m, int j, int n) {
        if (i > m || j > n) return 0;
        if (i == m && j == n) return 1;
        return cal(i + 1, m, j, n) + cal(i, m, j + 1, n);
    }

    public int uniquePathsFlat(int m, int n) {
        int[][] result = new int[m][n];
        result[0][0] = 1;

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (i > 0) result[i][j] += result[i - 1][j];
                if (j > 0) result[i][j] += result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }
}
