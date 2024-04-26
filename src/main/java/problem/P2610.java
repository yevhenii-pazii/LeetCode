package problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class P2610 {

    /*
        Time Complexity O(N * N)
        Space Complexity O(1)
     */
    public List<List<Integer>> findMatrixBruteForce(int[] nums) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>());

        MAIN: for (var num : nums) {

            MATRIX: for (List<Integer> row : matrix) { // list can be sorted, binary search could be used
                for (Integer integer : row) {
                    if (integer == num) {
                        continue MATRIX;
                    }
                }
                row.add(num);
                continue MAIN;
            }

            List<Integer> additional = new ArrayList<>();
            additional.add(num);
            matrix.add(additional);
        }

        return matrix;
    }


    /*
        Time Complexity O(?) based on HS
        Space Complexity O(1)
     */
    public List<List<Integer>> findMatrixHashSet(int[] nums) {
        List<Set<Integer>> matrix = new ArrayList<>();
        matrix.add(new HashSet<>());

        MAIN: for (var num : nums) {

            for (var row: matrix) {
                if (row.add(num)) {
                    continue MAIN;
                }
            }
            Set<Integer> additional = new HashSet<>();
            additional.add(num);
            matrix.add(additional);
        }

        return matrix.stream().map(set -> (List<Integer>) new ArrayList<>(set)).toList();
    }


    /*
        Time Complexity O(N) -> O(2 * N) as we are going twice
        Space Complexity O(N)
    */
    public List<List<Integer>> findMatrixCounting(int[] nums) {
        int max = 0;
        int[] count = new int[nums.length + 1];
        for (var num : nums) {
            max = Math.max(++count[num], max);
        }

        List<List<Integer>> result = new ArrayList<>(max);
        for (var i = 0; i < max; i++) {
            result.add(new ArrayList<>());
        }

        for (var i = 1; i < count.length; i++) {
            for (var rowIndex = count[i] - 1; rowIndex >= 0; rowIndex--) {
                result.get(rowIndex).add(i);
            }
        }
        return result;
    }

    /*
        The same as mine but arrays created on the fly

        Time Complexity O(N)
        Space Complexity O(N)
    */
    public List<List<Integer>> findMatrixOfficial(int[] nums) {
        int[] freq = new int[nums.length + 1];

        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int c : nums) {
            if (freq[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }

            // Store the integer in the list corresponding to its current frequency.
            ans.get(freq[c]).add(c);
            freq[c]++;
        }

        return ans;
    }

}
