package problem;

import java.util.Arrays;

public class P561 {

    /*
        Time Complexity O(N * log N) for sorting
        Space Complexity O(log N) Java sort
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        var sumOfEven = 0;
        for (var i = 0; i < nums.length; i += 2) {
            sumOfEven += nums[i];
        }

        return sumOfEven;
    }

    /*
        Time Complexity O(N + 2K)
        Space Complexity O(2K)
     */
    public int arrayPairSumCounting(int[] nums) {
        var k = 10_000;
        var count = new int[10_000 * 2 + 1];
        for (var num : nums) {
            count[num + k]++;
        }

        var sumOfEven = 0;
        var even = true;
        for (var i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                if (even) {
                    sumOfEven += i - k;
                }
                even = !even;
                count[i]--;
            }
        }

        return sumOfEven;
    }
}
