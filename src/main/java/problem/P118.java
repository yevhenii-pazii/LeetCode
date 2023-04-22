package problem;

import java.util.ArrayList;
import java.util.List;

public class P118 {

    /*
        This DP
        Time Complexity O(N^2)
        Space Complexity O(1)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> level1 = new ArrayList<>(1);
        level1.add(1);
        result.add(level1);

        List<Integer> previous = level1;
        List<Integer> current;
        for (var level = 2; level <= numRows; level++) {
            current = new ArrayList<>(level);
            current.add(1);

            var preciousNumber = 1;
            for (var i = 1; i < level - 1; i++) {
                var currentNumber = previous.get(i);
                current.add(preciousNumber + currentNumber);
                preciousNumber = currentNumber;
            }

            current.add(1);
            result.add(current);
            previous = current;
        }

        return result;
    }

    /*
        Improved, no need to calculate the second part of the level

        Time Complexity O(N^2)
        Space Complexity O(1)
     */
    public List<List<Integer>> generateV2(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> level1 = new ArrayList<>(1);
        level1.add(1);
        result.add(level1);

        List<Integer> previous = level1;
        List<Integer> current;
        for (var level = 2; level <= numRows; level++) {
            current = new ArrayList<>(level);
            current.add(1);

            var preciousNumber = 1;
            for (var i = 1; i < level / 2 + level % 2; i++) {
                var currentNumber = previous.get(i);
                current.add(preciousNumber + currentNumber);
                preciousNumber = currentNumber;
            }

            for (var i = level / 2 - 1; i >= 0 ; i--) {
                current.add(current.get(i));
            }

            result.add(current);
            previous = current;
        }

        return result;
    }
}
