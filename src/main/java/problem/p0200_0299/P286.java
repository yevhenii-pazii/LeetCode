package problem.p0200_0299;

import java.util.ArrayDeque;
import java.util.Queue;

class P286 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public void wallsAndGates(int[][] rooms) {
        int height = rooms.length, width = rooms[0].length;

        Queue<Integer> points = new ArrayDeque<>();

        for (var i = 0; i < height; i++) {
            for (var j = 0; j < width; j++) {
                if (rooms[i][j] == 0) {
                    points.add(i);
                    points.add(j);
                }
            }
        }

        int [][] moves = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        var distance = 1;
        while (!points.isEmpty()) {
            var count = points.size() / 2;
            for (var p = 0; p < count; p++) {
                int i = points.remove();
                int j = points.remove();

                for (var shift : moves) {
                    var newI = i + shift[0];
                    var newJ = j + shift[1];
                    if (newI >= 0 && newI < height
                            && newJ >=0 && newJ < width
                            && rooms[newI][newJ] == Integer.MAX_VALUE) {
                        points.add(newI);
                        points.add(newJ);
                        rooms[newI][newJ] = distance;
                    }
                }

            }
            distance++;
        }
    }

}
