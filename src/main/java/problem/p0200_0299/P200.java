package problem.p0200_0299;

import java.util.ArrayDeque;
import java.util.Queue;

class P200 {


    /*
        DFS
        Time Complexity O(M*N)
        Space Complexity O(M*N)
     */
    public int numIslandsRecursion(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    fillIsland(grid, i, m, j, n);
                }
            }
        }


        return islands;
    }

    private static void fillIsland(char[][] grid, int i, int m, int j, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '0';

        fillIsland(grid, i + 1, m, j, n);
        fillIsland(grid, i - 1, m, j, n);
        fillIsland(grid, i, m, j + 1, n);
        fillIsland(grid, i, m, j - 1, n);
    }


    /*
        BFS
        Time Complexity O(M*N)
        Space Complexity O(min(M,N))
     */
    public int numIslandsQueue(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;


        int[][] shifts = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> points = new ArrayDeque<>();

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    points.add(new int[]{i, j});

                    while (!points.isEmpty()) {
                        var point = points.remove();

                        if (grid[point[0]][point[1]] == '1') {

                            for (var shift : shifts) {
                                var newI = point[0] + shift[0];
                                var newJ = point[1] + shift[1];
                                if (newI >= 0 && newI < m
                                        && newJ >= 0 && newJ < n
                                        && grid[newI][newJ] == '1') {
                                    points.add(new int[]{newI, newJ});
                                }
                            }

                            grid[point[0]][point[1]] = '0';
                        }
                    }
                }
            }
        }

        return islands;
    }

    /*
        Union Find

        Unions operations is always one smaller than island, i.e.:  points 3 points 2 unions

        Time Complexity O(M*N)
        Space Complexity O(M*N)
     */
    public int numIslandsUnionFind(char[][] grid) {
        class UF {
            private final int[] parents;
            private final int[] size;

            public UF(int count) {
                this.parents = new int[count];
                this.size = new int[count];
                for (var i = 0; i < count; i++) {
                    parents[i] = i;
                    size[i] = 1;
                }
            }

            public int root(int p) {
                while (parents[p] != p) {
                    parents[p] = parents[parents[p]];
                    p = parents[p];
                }

                return p;
            }

            public boolean union(int p, int q) {
                int i = root(p);
                int j = root(q);

                if (i == j) return false;

                if (size[i] < size[j]) {
                    size[j] += size[i];
                    parents[i] = j;
                } else {
                    size[i] += size[j];
                    parents[j] = i;
                }

                return true;
            }
        }

        char land = '1';
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == land) {
                    islands++;
                    var current = j * m + i;


                    if (i - 1 >= 0 && grid[i - 1][j] == land && uf.union(current, current - 1))
                        islands--;
                    if (i + 1 < m && grid[i + 1][j] == land && uf.union(current, current + 1))
                        islands--;
                    if (j - 1 >= 0 && grid[i][j - 1] == land && uf.union(current, (j - 1) * m + i))
                        islands--;
                    if (j + 1 < n && grid[i][j + 1] == land && uf.union(current, (j + 1) * m + i))
                        islands--;
                }
            }
        }

        return islands;
    }
}
