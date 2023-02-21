public class P977 {

    public int[] sortedSquares(int[] nums) {
        var result = new int[nums.length];
        int i = 0, j = nums.length - 1;
        for (var k = nums.length -1 ; k >= 0; k--) {
            int num;

            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                num = nums[i];
                i++;
            } else {
                num = nums[j];
                j--;
            }

            result[k] = num * num;
        }

        return result;
    }
}
