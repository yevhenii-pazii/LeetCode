package problem.p0000_0099;

import java.util.ArrayList;
import java.util.List;

class P54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        var n = matrix.length;
        var m = matrix[0].length;
        List<Integer> result = new ArrayList<>(n * m);

        var moves = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        var iStart = 0;
        var jStart = 0;
        var i = 0;
        var j = 0;

        while (iStart <= n && jStart <= m) {
            i = iStart;
            j = jStart;

            for (var move : moves) {
                var g = 1;
                while (i + move[0] >= iStart && i < n - move[0] && j + move[1] >= jStart && j < m - move[1]) {
                    result.add(matrix[i][j]);
                    i += move[0];
                    j += move[1];
                }
                g = 2;
            }

            iStart++;
            jStart++;
            n--;
            m--;
        }


        result.add(matrix[i][j]);

        return result;
    }

    public List<Integer> spiralOrderV2(int[][] matrix) {
        var n = matrix.length;
        var m = matrix[0].length;

        List<Integer> result = new ArrayList<>(n * m);

        var up = 0;
        var down = n - 1;
        var left = 0;
        var right = m - 1;


        while (result.size() < n * m) {
            //left to right
            for (var j = left; j <= right; j++) {
                result.add(matrix[up][j]);
            }

            for (var i = up + 1; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            if (up != down) {
                for (var j = right - 1; j >= left; j--) {
                    result.add(matrix[down][j]);
                }
            }

            if (left != right) {
                for (var i = down - 1; i > up; i--) {
                    result.add(matrix[i][left]);
                }
            }

            up++;
            down--;
            left++;
            right--;
        }
        return result;
    }
}
