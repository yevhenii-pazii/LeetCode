package problem.p0400_0499;

class P487 {
    public static void main(String[] args) {
        System.out.println(new P487().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));
        System.out.println(new P487().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        var replacedCount = 0;
        var pureCount = 0;
        var maxCount = 0;

        for (var n : nums) {
            if (n == 0) {
                replacedCount = pureCount + 1;
                pureCount = 0;
            } else {
                replacedCount++;
                pureCount++;
            }
            maxCount = Math.max(replacedCount, maxCount);
        }

        return maxCount;
    }

    // This is official solution
    public int findMaxConsecutiveOnesOfficial(int[] nums) {
        int longestSequence = 0;
        int left = 0;
        int right = 0;
        int numZeroes = 0;

        // while our window is in bounds
        while (right < nums.length) {

            // add the right most element into our window
            if (nums[right] == 0) {
                numZeroes++;
            }

            // if our window is invalid, contract our window
            while (numZeroes == 2) {
                if (nums[left] == 0) {
                    numZeroes--;
                }
                left++;
            }

            // update our longest sequence answer
            longestSequence = Math.max(longestSequence, right - left + 1);

            // expand our window
            right++;
        }
        return longestSequence;
    }
}
