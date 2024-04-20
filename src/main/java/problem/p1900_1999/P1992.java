package problem.p1900_1999;

import java.util.ArrayList;

class P1992 {

    public int[][] findFarmland(int[][] land) {
        return null;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int[][] findFarmlandLoop(int[][] land) {
        var result = new ArrayList<int[]>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    int[] rectangle = new int[4];
                    rectangle[0] = i;
                    rectangle[1] = j;

                    for (int ir = i; ir < land.length && land[ir][j] == 1; ir++) {
                        for (int jr = j; jr < land[0].length && land[ir][jr] == 1; jr++) {
                            rectangle[2] = ir;
                            rectangle[3] = jr;
                            land[ir][jr] = -1;
                        }
                    }

                    result.add(rectangle);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
