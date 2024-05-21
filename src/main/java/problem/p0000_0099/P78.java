package problem.p0000_0099;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class P78 {

    public List<List<Integer>> subsets(int[] nums) {
        return null;
    }

    /*
        Time Complexity O(N * 2 ^ N) 57.66%
        Space Complexity O(2 ^ N) 59.10%
     */
    public List<List<Integer>> subsetsBacktrackingRecursion(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, List.of(), result);
        return result;
    }

    private static void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(current);
            return;
        }

        List<Integer> newCurrent = new ArrayList<>(current);
        newCurrent.add(nums[index]);


        helper(nums, index + 1, newCurrent, result);
        helper(nums, index + 1, current, result);
    }

    /*
        Time Complexity O(N * 2 ^ N) 57.66%
        Space Complexity O(2 ^ N) 74.43%
     */
    public List<List<Integer>> subsetsBacktrackingLoop(int[] nums) {
        Queue<List<Integer>> queue = new ArrayDeque<>((int) Math.pow(2, nums.length));
        queue.add(List.of());

        for (int num : nums) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                var list = queue.poll();
                var newList = new ArrayList<>(list);
                newList.add(num);
                queue.add(newList);
                queue.add(list);
            }
        }

        return new ArrayList<>(queue);
    }

    /*
        Not mine but similar to backtracking loop.

        Time Complexity O(N * 2 ^ N) 57.40%
        Space Complexity O(2 ^ N) 74.20%
     */
    public List<List<Integer>> subsetsCascading(int[] nums) {
        List<List<Integer>> output = new ArrayList<>((int) Math.pow(2, nums.length));
        output.add(List.of());

        for (var num: nums) {
            List<List<Integer>> subList = new ArrayList<>(output.size());

            for (var o : output) {
                var newList = new ArrayList<>(o);
                newList.add(num);
                subList.add(newList);
            }

            output.addAll(subList);
        }

        return output;
    }
}
