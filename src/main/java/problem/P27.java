package problem;

public class P27 {


    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int removeElementCopyFromBack(int[] nums, int val) {
        var length = nums.length;
        var i = 0;
        while (i < length) {
            if (nums[i] == val) {
                nums[i] = nums[--length];
            } else {
                i++;
            }
        }
        return length;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int removeElementV3(int[] nums, int val) {
        var j = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int removeElementV2(int[] nums, int val) {
        var pointer = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (pointer < i) { // in this case if can be omitted
                    nums[pointer] = nums[i];
                }
                pointer++;
            }
        }

        return pointer;
    }

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


}