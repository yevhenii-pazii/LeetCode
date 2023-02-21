public class P27 {
    public int removeElement(int[] nums, int val) {
        var removed = 0;
        for (int i = 0; i + removed < nums.length; i++) {
            while (nums[i] == val && i + ++removed != nums.length) {
                var lastNotRemoved = nums.length - removed;
                var holder = nums[lastNotRemoved];
                nums[lastNotRemoved] = nums[i];
                nums[i] = holder;
            }
        }

        return nums.length - removed;
    }

/* from discussions
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }

*/
}