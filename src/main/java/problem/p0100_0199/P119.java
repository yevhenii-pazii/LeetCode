package problem.p0100_0199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P119 {

    /*
        Time complexity O(rowIndex ^ 2)
        Space complexity O(rowIndex)
     */
    public List<Integer> getRowLoop(int rowIndex) {
        int[] row = new int[rowIndex + 1];
        row[0] = 1;

        var previous = 0;
        var current = 0;
        for (var currentIndex = 1; currentIndex <= rowIndex; currentIndex++) {
            for (var i = 0; i <= currentIndex; i++) {
                current = previous + row[i];
                previous = row[i];
                row[i] = current;
            }
        }

        List<Integer> result = new ArrayList<>(row.length);
        for (var n : row) {
            result.add(n);
        }
        return result;
    }


    /*
        Time complexity O(rowIndex ^ 2)
        Space complexity O(rowIndex) if count the output
     */
    public List<Integer> getRowLoopV2(int rowIndex) {
        var row = new Integer[rowIndex + 1];

        for (var i = 0; i <= rowIndex; i++) {
            row[i] = 1;
            for (var j = i - 1; j > 0; j--) {
                row[j] += row[j - 1];
            }
        }

        return Arrays.asList(row);
    }

    /*
        Time complexity O(2^rowIndex)
        Space complexity O(rowIndex)
    */
    public List<Integer> getRowRecursion(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (var i = 0; i <= rowIndex; i++) {
            result.add(itemHelper(i, rowIndex));
        }

        return result;
    }

    private int itemHelper(int itemIndex, int rowIndex) {
        if (itemIndex == 0 || itemIndex == rowIndex) return 1;
        rowIndex--;
        return itemHelper(itemIndex - 1, rowIndex) + itemHelper(itemIndex, rowIndex);
    }


    //One more solution, combinatorics
}
