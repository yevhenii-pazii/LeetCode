import java.util.Arrays;

public class P80 {

    public static void main(String[] args) {
        var arr = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(new P80().removeDuplicates(arr) + " " + Arrays.toString(arr));
        System.out.println(new P80().removeDuplicatesV2(arr) + " " + Arrays.toString(arr));
    }


    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int position = 1;
        int repeatitions = 1;

        for (var i = 1; i < nums.length; i++) {
            boolean equalToPrevious = nums[i] == nums[position - 1];

            if (equalToPrevious) {
                repeatitions++;
            } else {
                repeatitions = 1;
            }

            if (!equalToPrevious || repeatitions < 3) {
                nums[position] = nums[i];
                position++;
            }
        }

        return position;
    }

    public int removeDuplicatesV2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 3) return nums.length;

        int position = 2;
        for (var i = 2; i < nums.length; i++) {
            if (nums[i] != nums[position - 2]) {
                nums[position] = nums[i];
                position++;
            }
        }

        return position;
    }

    /*
     Difficult but working and nice
     */
    public int removeDuplicatesFromDiscussions(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

}
