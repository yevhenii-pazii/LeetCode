package problem.p0200_0299;

class P209 {

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int minSubArrayLenTwoPointers(int target, int[] nums) {
        var minSubArrayLength = Integer.MAX_VALUE;
        var subArraySum = 0;
        var beginIndex = 0;
        for (var endIndex = 0; endIndex < nums.length; endIndex++) {
            subArraySum += nums[endIndex];

            if (subArraySum >= target) {
                while (subArraySum - nums[beginIndex] >= target) {
                    subArraySum -= nums[beginIndex++];
                }
                minSubArrayLength = Math.min(minSubArrayLength, endIndex - beginIndex + 1);
            }
        }

        return minSubArrayLength == Integer.MAX_VALUE ? 0 : minSubArrayLength;
    }

    //TODO sum and binary search, Time Complexity O(N * log N)
}
