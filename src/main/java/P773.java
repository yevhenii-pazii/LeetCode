import java.util.LinkedList;
import java.util.Queue;

public class P773 {

    public static void main(String[] args) {
        print(new P773()
                .floodFill(new int[][] {{1,1,1}, {1,1,0}, {1,0,1}}, 1, 1, 2));

        print(new P773()
                .floodFillRecursive(new int[][] {{1,1,1}, {1,1,0}, {1,0,1}}, 1, 1, 2));
    }

    private static void print(int [][] image) {
        for (var row : image) {
            for (var pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

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

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
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
}
