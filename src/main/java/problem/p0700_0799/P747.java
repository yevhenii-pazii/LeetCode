package problem.p0700_0799;

class P747 {

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int dominantIndex(int[] nums) {
        var maxIndex = nums[0] > nums[1] ? 0 : 1;
        var secondMax = Math.min(nums[0], nums[1]);

        for (var i = 2; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                secondMax = nums[maxIndex];
                maxIndex = i;
            } else {
                secondMax = Math.max(secondMax, nums[i]);
            }
        }

        return  secondMax * 2 <= nums[maxIndex] ? maxIndex : -1;
    }
}
