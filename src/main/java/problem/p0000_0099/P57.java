package problem.p0000_0099;

import java.util.ArrayList;
import java.util.List;

class P57 {

    /*
        Time Complexity O(N)
        Space Complexity O(1) -> storing links not actual data
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> result = new ArrayList<>(intervals.length + 1);

        var i = 0;
        for (; i < intervals.length && intervals[i][1] < newInterval[0]; i++) {
            result.add(intervals[i]);
        }


        var start = i < intervals.length ? Math.min(intervals[i][0], newInterval[0]) : newInterval[0];
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            i++;
        }
        result.add(new int[]{start, i > 0 ? Math.max(intervals[i - 1][1], newInterval[1]) :  newInterval[1]});
        for (; i < intervals.length; i++) {
            result.add(intervals[i]);
        }


        return result.toArray(new int[0][0]);
    }

}
