package problem;

import java.util.ArrayDeque;
import java.util.Queue;

public class P1020 {

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

    public int numEnclavesUnionFind(int[][] grid) {
        var height = grid.length;
        var width = grid[0].length;
        if (height < 3 || width < 3) return 0;

        var borderPoint = height * width;
        var uf = new UnionFind(borderPoint + 1);

        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    uf.union(i * width + j, borderPoint);
                }

                if (grid[i][j] == 1 && i < height - 1 && j < width - 1) {
                    if (grid[i + 1][j] == 1) {
                        uf.union(i * width + j, (i + 1) * width + j);
                    }

                    if (grid[i][j + 1] == 1) {
                        uf.union(i * width + j, i * width + j + 1);
                    }
                }
            }
        }

        var result = 0;
        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                if (grid[i][j] == 1 && !uf.connected(i * width + j, borderPoint)) {
                    result++;
                }
            }
        }

        return result;
    }

    public int numEnclavesUnionFindWithTranslation(int[][] grid) {
        var height = grid.length;
        var width = grid[0].length;
        if (height < 3 || width < 3) return 0;

        var translate = new int[height][width];
        var counter = 0;
        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                translate[i][j] = counter++;
            }
        }

        var borderPoint = height * width;
        var uf = new UnionFind(borderPoint + 1);

        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    uf.union(translate[i][j], borderPoint);
                }

                if (grid[i][j] == 1 && i < height - 1 && j < width - 1) {
                    if (grid[i + 1][j] == 1) {
                        uf.union(translate[i][j], translate[i + 1][j]);
                    }

                    if (grid[i][j + 1] == 1) {
                        uf.union(translate[i][j], translate[i][j + 1]);
                    }
                }
            }
        }

        counter = 0;
        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                if (grid[i][j] == 1 && !uf.connected(i * width + j, borderPoint)) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public int numEnclavesRecursion(int[][] grid) {
        var height = grid.length;
        var width = grid[0].length;
        if (height < 3 || width < 3) return 0;

        var visited = new boolean[height][width];

        var fixed = height - 1;
        for (var j = 0; j < width; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                traverseRecursion(0, j, height, width, grid, visited);
            }
            if (grid[fixed][j] == 1 && !visited[fixed][j]) {
                traverseRecursion(fixed, j, height, width, grid, visited);
            }
        }
        fixed = width - 1;
        for (var i = 0; i < height; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                traverseRecursion(i, 0, height, width, grid, visited);
            }
            if (grid[i][fixed] == 1 && !visited[i][fixed]) {
                traverseRecursion(i, fixed, height, width, grid, visited);
            }
        }

        var result = 0;
        for (var i = 1; i < height - 1; i++) {
            for (var j = 1; j < width - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    result++;
                }
            }
        }

        return result;
    }

    private void traverseRecursion(int i, int j, int height, int width, int[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= height || j >= width || visited[i][j] || grid[i][j] == 0) return;
        visited[i][j] = true;
        traverseRecursion(i + 1, j, height, width, grid, visited);
        traverseRecursion(i - 1, j, height, width, grid, visited);
        traverseRecursion(i, j + 1, height, width, grid, visited);
        traverseRecursion(i , j - 1, height, width, grid, visited);
    }


    public int numEnclavesLoop(int[][] grid) {
        var height = grid.length;
        var width = grid[0].length;
        if (height < 3 || width < 3) return 0;

        var visited = new boolean[height][width];

        var fixed = height - 1;
        for (var j = 0; j < width; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                traverseLoop(0, j, height, width, grid, visited);
            }
            if (grid[fixed][j] == 1 && !visited[fixed][j]) {
                traverseLoop(fixed, j, height, width, grid, visited);
            }
        }
        fixed = width - 1;
        for (var i = 0; i < height; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                traverseLoop(i, 0, height, width, grid, visited);
            }
            if (grid[i][fixed] == 1 && !visited[i][fixed]) {
                traverseLoop(i, fixed, height, width, grid, visited);
            }
        }

        var result = 0;
        for (var i = 1; i < height - 1; i++) {
            for (var j = 1; j < width - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    result++;
                }
            }
        }

        return result;
    }

    private void traverseLoop(int i, int j, int height, int width, int[][] grid, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) { // flood border islands
            var point = queue.remove();
            i = point[0];
            j = point[1];

            visited[i][j] = true;

            //requires improvement

            if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] == 1) {
                queue.add(new int[]{i - 1, j});
            }
            if (i < height - 1 && !visited[i + 1][j] && grid[i + 1][j] == 1) {
                queue.add(new int[]{i + 1, j});
            }
            if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] == 1) {
                queue.add(new int[]{i, j - 1});
            }
            if (j < width - 1 && !visited[i][j + 1] && grid[i][j + 1] == 1) {
                queue.add(new int[]{i, j + 1});
            }

            //requires improvement
        }
    }

}
