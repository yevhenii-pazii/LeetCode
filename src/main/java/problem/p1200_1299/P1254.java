package problem.p1200_1299;

import java.util.ArrayDeque;
import java.util.Queue;

class P1254 {

    private static class UnionFind {
        private int[] parent;
        private int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (var i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        void union(int p1, int p2) {
            p1 = find(p1);
            p2 = find(p2);
            if (p1 != p2) {
                if (rank[p1] < rank[p2]) {
                    rank[p2] += rank[p1];
                    parent[p1] = p2;
                } else {
                    rank[p1] += rank[p2];
                    parent[p2] = p1;
                }
            }
        }

        boolean connected(int p1, int p2) {
            return find(p1) == find(p2);
        }

    }

    /*
        Pure UnionFind


        Time Complexity O() ??
        Space Complexity O() ??
     */
    public int closedIslandUnionFind(int[][] grid) {
        var height = grid.length;
        var width = grid[0].length;
        if (height == 1 || width == 1) return 0;
        var exitPoint = height * width;
        var island = exitPoint + 1;


        var uf = new UnionFind(island + 1);
        for (var i = 0; i < height; i++) {
            uf.union(i * width, exitPoint);
            uf.union(i * width + width - 1, exitPoint);
        }
        for (var j = 0; j < width; j++) {
            uf.union(j, exitPoint);
            uf.union((height - 1) * width + j, exitPoint);
        }


        for (var i = 0; i < height - 1; i++) { // union all islands
            for (var j = 0; j < width - 1; j++) {
                if (grid[i][j] == 0) {
                    if (grid[i][j + 1] == 0) {
                        uf.union(i * width + j, i * width + j + 1);
                    }
                    if (grid[i + 1][j] == 0) {
                        uf.union(i * width + j, (i + 1) * width + j);
                    }
                }
            }
        }
        if (grid[height - 1][width - 1] == 0) { //redundant
            if (grid[height - 2][width - 1] == 0) {
                uf.union((height - 1) * width + width - 1, (height - 2) * width + width - 1);
            }
            if (grid[height - 1][width - 2] == 0) {
                uf.union((height - 1) * width + width - 1, (height - 1) * width + width - 2);
            }
        }

        var result = 0;

        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                if (grid[i][j] == 0
                        && !uf.connected(i * width + j, exitPoint)
                        && !uf.connected(i * width + j, island)) {
                    result++;
                    uf.union(i * width + j, island);
                }
            }
        }

        return result;
    }

    /*
        Pure UnionFind with translation matrix


        Time Complexity O() ??
        Space Complexity O() ??
    */
    public int closedIslandUnionFindWithTranslation(int[][] grid) {
        var height = grid.length;
        var width = grid[0].length;
        if (height == 1 || width == 1) return 0;

        var translate = new int[height][width];
        var point = 0;
        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                translate[i][j] = point++;
            }
        }

        var exitPoint = height * width;
        var island = exitPoint + 1;
        var uf = new UnionFind(island + 1);

        point = width - 1;
        for (var i = 0; i < height; i++) {
            uf.union(translate[i][0], exitPoint);
            uf.union(translate[i][point], exitPoint);
        }
        point = height - 1;
        for (var j = 0; j < width; j++) {
            uf.union(translate[0][j], exitPoint);
            uf.union(translate[point][j], exitPoint);
        }


        for (var i = 0; i < height - 1; i++) { // union all islands
            for (var j = 0; j < width - 1; j++) {
                if (grid[i][j] == 0) {
                    if (grid[i][j + 1] == 0) {
                        uf.union(translate[i][j], translate[i][j + 1]);
                    }
                    if (grid[i + 1][j] == 0) {
                        uf.union(translate[i][j], translate[i + 1][j]);
                    }
                }
            }
        }
//        if (grid[height - 1][width - 1] == 0) { //redundant
//            if (grid[height - 2][width - 1] == 0) {
//                uf.union((height - 1) * width + width - 1, (height - 2) * width + width - 1);
//            }
//            if (grid[height - 1][width - 2] == 0) {
//                uf.union((height - 1) * width + width - 1, (height - 1) * width + width - 2);
//            }
//        }

        var result = 0;

        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                if (grid[i][j] == 0
                        && !uf.connected(translate[i][j], exitPoint)
                        && !uf.connected(translate[i][j], island)) {
                    result++;
                    uf.union(translate[i][j], island);
                }
            }
        }

        return result;
    }

    /*
        Depth First (recursion)
        Time Complexity O(N*M)
        Space Complexity O(N*M)
     */
    public int closedIslandRecursion(int[][] grid) {
        var height = grid.length;
        var width = grid[0].length;
        if (height == 1 || width == 1) return 0;

        var result = 0;
        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                if (grid[i][j] == 0 && recursionHelper(grid, i, height, j, width)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean recursionHelper(int[][] grid, int i, int height, int j, int width) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return false;
        }

        if (grid[i][j] == 1) {
            return true;
        } else {
            grid[i][j] = 1;
            // & used to travel the island even if it failed to be closed
            return recursionHelper(grid, i + 1, height, j, width)
                    & recursionHelper(grid, i - 1, height, j, width)
                    & recursionHelper(grid, i, height, j + 1, width)
                    & recursionHelper(grid, i, height, j - 1, width);
        }
    }



    /*
        Breadth First
        Time Complexity O(N*M)
        Space Complexity O(N*M)
     */
    public int closedIslandTraverse(int[][] grid) {
        var height = grid.length;
        var width = grid[0].length;
        if (height == 1 || width == 1) return 0; // optional

        var result = 0;
        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                if (grid[i][j] == 0 && traverse(grid, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean traverse(int[][] grid, int i, int j) {
        var height = grid.length;
        var width = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});

        var valid = true;

        while (!queue.isEmpty()) {
            var point = queue.remove();
            i = point[0];
            j = point[1];

            if (i < 0 || i >= height || j < 0 || j >= width) {
                valid = false;
                continue;
            }

            if (grid[i][j] == 0) {
                grid[i][j] = 1;
                queue.add(new int[]{i + 1, j});
                queue.add(new int[]{i - 1, j});
                queue.add(new int[]{i, j + 1});
                queue.add(new int[]{i, j - 1});
            }
        }

        return valid;
    }
}
