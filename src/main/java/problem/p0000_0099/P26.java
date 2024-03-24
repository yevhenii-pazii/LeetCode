package problem.p0000_0099;

class P26 {

    public int removeDuplicates(int[] nums) {
        var removed = 0;
        var i = 1;
        while (i + removed < nums.length) {
            if (nums[i - 1] == nums[i]) {
                for (var j = i + 1; j + removed < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                removed++;
            } else {
                i++;
            }
        }

        return nums.length - removed;
    }

    // My V2, much better than previously
    public int removeDuplicatesV2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums.length;

        int position = 1;

        for (var i = 1; i < nums.length; i++) {
            if (nums[i] != nums[position - 1]) {
                nums[position] = nums[i];
                position++;
            }
        }

        return position;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int removeDuplicatesTwoPointers(int[] nums) {
        var pointer = 1;
        for (var i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[pointer++] = nums[i];
            }
        }

        return pointer;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(K) K - space for additional array
     */
    public int removeDuplicatesCounting(int[] nums) {
        var numbers = new boolean[201]; //task constraint

        for (var n : nums) {
            numbers[n + 100] = true;
        }

        var numsPointer = 0;
        for (var i = 0; i < numbers.length; i++) {
            if (numbers[i]) {
                nums[numsPointer++] = i - 100;
            }
        }

        return numsPointer;
    }


}