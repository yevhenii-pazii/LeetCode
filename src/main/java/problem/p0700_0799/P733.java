package problem.p0700_0799;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class P733 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)

        N is the number of pixels in the image. We might process every pixel.
     */
    public int[][] floodFillRecursive(int[][] image, int sr, int sc, int color) {
        fillPoint(image, sr, image.length, sc, image[0].length, image[sr][sc], color);
        return image;
    }

    private void fillPoint(int[][] image, int r, int rsize, int c, int csize, int colorFrom, int colorTo) {
        if (r < 0 || r >= rsize || c < 0 || c >= csize || image[r][c] != colorFrom || colorFrom == colorTo) return;
        image[r][c] = colorTo;
        fillPoint(image, r - 1, rsize, c, csize, colorFrom, colorTo);
        fillPoint(image, r + 1, rsize, c, csize, colorFrom, colorTo);
        fillPoint(image, r, rsize, c - 1, csize, colorFrom, colorTo);
        fillPoint(image, r, rsize, c + 1, csize, colorFrom, colorTo);
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)

        N is the number of pixels in the image. We might process every pixel.
     */
    public int[][] floodFillQueue(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        int m = image.length, n = image[0].length;
        int colorToReplace = image[sr][sc];
        Queue<Integer> points = new LinkedList<>();
        points.add(sr);
        points.add(sc);

        while (!points.isEmpty()) {
            var row = points.remove();
            var col = points.remove();

            if (image[row][col] == colorToReplace) {

                if (col - 1 >= 0 && image[row][col - 1] == colorToReplace) {
                    points.add(row);
                    points.add(col - 1);
                }

                if (col + 1 < n && image[row][col + 1] == colorToReplace) {
                    points.add(row);
                    points.add(col + 1);
                }

                if (row - 1 >= 0 && image[row - 1][col] == colorToReplace) {
                    points.add(row - 1);
                    points.add(col);
                }

                if (row + 1 < m && image[row + 1][col] == colorToReplace) {
                    points.add(row + 1);
                    points.add(col);
                }

                image[row][col] = color;
            }

        }

        return image;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)

        N is the number of pixels in the image. We might process every pixel.
     */
    public int[][] floodFillQueueV2(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;

        var replacing = image[sr][sc];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sr, sc});

        while (!queue.isEmpty()) {
            var point = queue.remove();
            if (image[point[0]][point[1]] == replacing) {
                image[point[0]][point[1]] = color;

                if (point[0] > 0) {
                    queue.add(new int[] {point[0] - 1, point[1]});
                }

                if (point[0] < image.length - 1) {
                    queue.add(new int[] {point[0] + 1, point[1]});
                }

                if (point[1] > 0) {
                    queue.add(new int[] {point[0], point[1] - 1});
                }

                if (point[1] < image[0].length - 1) {
                    queue.add(new int[] {point[0], point[1] + 1});
                }
            }
        }

        return image;
    }
}
