package problem;

public class P2439 {


    /*
        Performance is really poor
     */
    public int minimizeArrayValueBruteForce(int[] nums) {
        var changed = false;
        do {
            changed = false;
            for (var i = nums.length - 1; i >= 1; i--) {
                if (nums[i] > nums[i - 1]) {
                    changed = true;
                    var sum = nums[i] + nums[i - 1];
                    nums[i - 1] = sum / 2 + sum % 2;
                    nums[i] = sum - nums[i - 1];
                }
            }
        } while (changed);

        return nums[0];
    }

    /*
        Not mine :(
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int minimizeArrayValue(int[] nums) {
        // Initialize answer and the prefix sum.
        long answer = 0, prefixSum = 0;

        // Iterate over nums, update prefix sum and answer.
        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            answer = Math.max(answer, (prefixSum + i) / (i + 1));
        }

        return (int) answer;
    }
}
