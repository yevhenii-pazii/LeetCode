package problem.p0400_0499;

class P498 {
    public int[] findDiagonalOrder(int[][] mat) {
        var result = new int[mat.length * mat[0].length];

        var resultIndex = 0;
        var diagonalIndex = 0;
        var goUp = true;
        var i = 0;
        var j = 0;
        while (resultIndex < result.length) {
            if (goUp) {
                i = diagonalIndex;
                j = 0;
            } else {
                i = 0;
                j = diagonalIndex;
            }

            while (i >= 0 && j >= 0) {
                if (i < mat.length && j < mat[0].length) {
                    result[resultIndex++] = mat[i][j];
                }

                if (goUp) {
                    i--;
                    j++;
                } else {
                    i++;
                    j--;
                }

            }

            goUp = !goUp;
            diagonalIndex++;
        }

        return result;
    }

    public int[] findDiagonalOrderV2(int[][] mat) {
        var n = mat.length;
        var m = mat[0].length;
        var result = new int[n * m];
        var resultIndex = 0;
        var diagonalIndex = 0;
        var goUp = true;
        var i = 0;
        var j = 0;
        while (resultIndex < result.length) {
            if (goUp) {
                i = Math.min(diagonalIndex, n - 1);
                j = diagonalIndex - i;
            } else {
                j = Math.min(diagonalIndex, m - 1);
                i = diagonalIndex - j;
            }

            while (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length) {
                result[resultIndex++] = mat[i][j];
                if (goUp) {
                    i--;
                    j++;
                } else {
                    i++;
                    j--;
                }

            }

            goUp = !goUp;
            diagonalIndex++;
        }

        return result;
    }
}
