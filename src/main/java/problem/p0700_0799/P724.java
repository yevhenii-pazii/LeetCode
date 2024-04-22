package problem.p0700_0799;

class P724 {

    /*
        Official
     */
    public int pivotIndexOfficial(int[] nums) {
        int leftSum = 0, rightSum = 0;
        for (var num : nums) {
            rightSum += num;
        }
        for (var i = 0; i < nums.length; ++i) {
            if ((rightSum -= nums[i]) == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int pivotIndex(int[] nums) {
        var rightSum = 0;
        for (var i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        var leftSum = 0;
        var index = 0;
        while (leftSum != rightSum && index + 1 < nums.length) {
            leftSum += nums[index];
            rightSum -= nums[index + 1];
            index++;
        }

        return leftSum == rightSum ? index : -1;
    }
}