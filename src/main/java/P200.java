public class P200 {

    public static void main(String[] args) {
        System.out.println(new P200().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '0', '0', '1'},
                {'1', '0', '1', '1', '0'},
                {'1', '0', '0', '0', '1'}
        }));

        System.out.println(new P200().numIslandsRecursion(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '0', '0', '1'},
                {'1', '0', '1', '1', '0'},
                {'1', '0', '0', '0', '1'}
        }));
    }

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


    public int numIslands(char[][] grid) {
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
