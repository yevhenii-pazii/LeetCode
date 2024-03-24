package problem.p0200_0299;

class P283 {

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (pointer != i) {
                    nums[pointer] = nums[i];
                    nums[i] = 0;
                }
                pointer++;
            }
        }
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public void moveZeroesTwoPointers(int[] nums) {
        var pointer = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pointer++] = nums[i];
            }
        }

        for (; pointer < nums.length; pointer++) {
            nums[pointer] = 0;
        }
    }
}
