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

        (prefixSum + i) / (i + 1) i really smart thing

        prefixSum / (i + 1)  returns only full division
            like 13 / 3 -> 4 ,
            but we need to have 5 as one of numbers must accumulate the rest
         so  (prefixSum + i) / (i + 1) solves this
            (13 + 2) / 3 -> 5
            (12 + 2) / 3 -> 4
         and so on...
    */
    public int minimizeArrayValue(int[] nums) {
        // Initialize answer and the prefix sum.
        long answer = nums[0], prefixSum = 0;

        // Iterate over nums, update prefix sum and answer.
        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            answer = Math.max(answer, (prefixSum + i) / (i + 1));
        }

        return (int) answer;
    }
}
