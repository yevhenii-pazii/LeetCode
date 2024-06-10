package problem.p1000_1099;

import java.util.Arrays;

class P1051 {

    public int heightChecker(int[] heights) {
        return 0;
    }

    /*
        Time Complexity O(N * Log N) 88.93%
        Space Complexity O(N) 80.38%
     */
    public int heightCheckerArraySort(int[] heights) {
        var copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);

        var result = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                result++;
            }
        }

        return result;
    }

    /*
        Time Complexity O(N) 100%
        Space Complexity O(K) 97.64%, K - all possible heights
     */
    public int heightCheckerCounting(int[] heights) {
        int[] counts = new int[101];

        for (int height : heights) {
            counts[height]++;
        }

        int result = 0;
        for (int i = heights.length - 1, height = counts.length - 1; i >= 0; i--) {
            while (counts[height] == 0) {
                height--;
            }

            if (heights[i] != height) {
                result++;
            }
            counts[height]--;
        }

        return result;
    }

    // Using Counting Sort algorithm, old implementation 2023
    public int heightCheckerOld(int[] heights) {
        var indexes = new int[101];
        var result = 0;
        //var sorted = new int[heights.length];

        for (var h : heights) {
            indexes[h]++;
        }

        for (var i = 1 ; i < indexes.length; i++) {
            indexes[i] += indexes[i - 1];
        }

        for (var i = 0 ; i < heights.length; i++) {
            /*
            var h = heights[i];
            var newIndex = --indexes[h];
            //sorted[newIndex] = h;
            if (heights[newIndex] != h) result++;
             */

            //sorted[newIndex] = h;
            if (heights[--indexes[heights[i]]] != heights[i]) result++; //Complicated because it is collapsed the full version is above
        }

        return result;
    }
}
