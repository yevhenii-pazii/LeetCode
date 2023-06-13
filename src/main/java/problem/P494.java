package problem;

import java.util.ArrayDeque;
import java.util.Queue;

public class P494 {

    /*
        Time Complexity O(2 ^ N) Time limit exceed
        Space Complexity O(N)
     */
    public int findTargetSumWaysQueue(int[] nums, int target) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        for (int num : nums) {
            var size = queue.size();
            for (var j = 0; j < size; j++) {
                int current = queue.remove();
                queue.add(current + num);
                queue.add(current - num);
            }
        }

        var count = 0;
        while (!queue.isEmpty()) {
            if (target == queue.remove()) {
                count++;
            }
        }


        return count;
    }

    /*
        Time Complexity O(2 ^ N) Time limit exceed
        Space Complexity O(N)
     */
    public int findTargetSumWaysRecursion(int[] nums, int target) {
        return recursionHelper(nums, target, 0, 0);
    }

    private int recursionHelper(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        return recursionHelper(nums, target, index + 1, sum + nums[index])
                + recursionHelper(nums, target, index + 1, sum - nums[index]);
    }

}
