package problem.p2300_2399;

class P2373 {

    private static final int[][] shifts = new int[][]{
        {-1, -1},
        {-1, 0},
        {-1, 1},
        {0, -1},
        {0, 1},
        {1, -1},
        {1, 0},
        {1, 1}
    };

    public int[][] largestLocal(int[][] grid) {
        return null;
    }

    /*
        Time Complexity O(N*N) 10.5%  all matrix elements
        Space Complexity O(N*N) 62.9% only result
     */
    public int[][] largestLocalArray(int[][] grid) {
        int[][] result = new int[grid.length - 2][grid.length - 2]; //It is OK NxN

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                int gI = i + 1;
                int gJ = j + 1;

                result[i][j] = grid[gI][gJ];

                for (int[] shift : shifts) {
                    result[i][j] = Math.max(result[i][j], grid[gI + shift[0]][gJ + shift[1]]);
                }
            }
        }

        return result;
    }

    /*
        Time Complexity O(N*N) 62.99%  all matrix elements
        Space Complexity O(N*N) 18.42% only result
     */
    public int[][] largestLocalArray2(int[][] grid) {
        int[][] result = new int[grid.length - 2][grid.length - 2]; //It is OK NxN

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {

                var maxElement = 0;
                for (int x = i; x <= i + 2; x++) {
                    for (int y = j; y <= j + 2; y++) {
                        maxElement = Math.max(maxElement, grid[x][y]);
                    }
                }

                result[i][j] = maxElement;
            }
        }

        return result;
    }

}
