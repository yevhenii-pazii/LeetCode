package problem.p0500_0599;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class P542 {


    /*
        Time Complexity O(N * N)
        Space Complexity O(N * N)

        Time limit exceed
     */
    public int[][] updateMatrixQueue(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];

        for (var i = 0; i < mat.length; i++) {
            for (var j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});
                    var distance = 0;
                    MAIN:
                    while (!queue.isEmpty()) {
                        var size = queue.size();
                        for (var ql = 0; ql < size; ql++) {
                            var p = queue.remove();
                            if (mat[p[0]][p[1]] == 0) {
                                break MAIN;
                            }

                            if (p[0] > 0) {
                                queue.add(new int[]{p[0] - 1, p[1]});
                            }

                            if (p[0] < mat.length - 1) {
                                queue.add(new int[]{p[0] + 1, p[1]});
                            }

                            if (p[1] > 0) {
                                queue.add(new int[]{p[0], p[1] - 1});
                            }

                            if (p[1] < mat[i].length - 1) {
                                queue.add(new int[]{p[0], p[1] + 1});
                            }

                        }
                        distance++;
                    }
                    result[i][j] = distance;
                }
            }
        }

        return result;
    }

    /*
        Time Complexity O(N * N)
        Space Complexity O(N)

        Time too slow
     */
    public int[][] updateMatrixQueueV2(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        for (var i = 0; i < mat.length; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (var i = 0; i < mat.length; i++) {
            for (var j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 0) {
                    queue.add(new int[]{i, j});
                } else {
                    result[i][j] = 0;
                }
            }
        }

        var distance = 0;
        while (!queue.isEmpty()) {
            var qSize = queue.size();
            for (var i = 0; i < qSize; i++) {
                var p = queue.remove();

                if (p[0] > 0 && result[p[0] - 1][p[1]] == distance) {
                    result[p[0]][p[1]] = distance + 1;
                    continue;
                }

                if (p[0] < mat.length - 1 && result[p[0] + 1][p[1]] == distance) {
                    result[p[0]][p[1]] = distance + 1;
                    continue;
                }

                if (p[1] > 0 && result[p[0]][p[1] - 1] == distance) {
                    result[p[0]][p[1]] = distance + 1;
                    continue;
                }

                if (p[1] < mat[0].length - 1 && result[p[0]][p[1] + 1] == distance) {
                    result[p[0]][p[1]] = distance + 1;
                    continue;
                }

                queue.add(p);
            }
            distance++;
        }

        return result;
    }

    public int[][] updateMatrixQueueV3(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new ArrayDeque<>();
        for (var i = 0; i < mat.length; i++) {
            for (var j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;

                    for (var move : moves) {
                        if (i + move[0] >= 0
                                && i + move[0] < mat.length
                                && j + move[1] >= 0
                                && j + move[1] < mat[i].length) {
                            queue.add(new int[]{i + move[0], j + move[1]});
                        }
                    }

                } else {
                    result[i][j] = -1;
                }
            }
        }

        var distance = 1;
        while (!queue.isEmpty()) {
            var qSize = queue.size();
            for (var i = 0; i < qSize; i++) {
                var p = queue.remove();

                if (result[p[0]][p[1]] != -1) {
                    continue;
                }

                result[p[0]][p[1]] = distance;

                for (var move : moves) {
                    if (p[0] + move[0] >= 0
                            && p[0] + move[0] < mat.length
                            && p[1] + move[1] >= 0
                            && p[1] + move[1] < mat[p[0]].length
                            && result[p[0] + move[0]][p[1] + move[1]] == -1) {
                        queue.add(new int[]{p[0] + move[0], p[1] + move[1]});
                    }
                }
            }
            distance++;
        }

        return result;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int[][] updateMatrixQueueV4(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new ArrayDeque<>();
        for (var i = 0; i < mat.length; i++) {
            for (var j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(new int[] {i, j});

                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        var distance = 1;
        while (!queue.isEmpty()) {
            var qSize = queue.size();
            for (var q = 0; q < qSize; q++) {
                var p = queue.remove();

                for (var move : moves) {
                    var i = p[0] + move[0];
                    var j = p[1] + move[1];
                    if (i >= 0 && i < mat.length && j >= 0 && j < mat[i].length
                            && result[i][j] == Integer.MAX_VALUE) {
                        result[i][j] = distance;
                        queue.add(new int[]{i, j});
                    }
                }
            }
            distance++;
        }
        return result;
    }

    //TODO dynamic programming
}
