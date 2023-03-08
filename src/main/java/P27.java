import java.util.Arrays;

public class P27 {

    public static void main(String[] args) {
        var arr = new int[] {3,2,2,3};
        System.out.print(new P27().removeElementV2(arr, 3) + " -> ");
        System.out.print(Arrays.toString(arr));
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