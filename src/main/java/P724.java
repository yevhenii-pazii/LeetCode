public class P724 {

    public int pivotIndex(int[] nums) {
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
}