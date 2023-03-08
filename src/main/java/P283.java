import java.util.Arrays;

public class P283 {

    public static void main(String[] args) {
        var arr = new int[]{0, 1, 0, 3, 12};
        new P283().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int pointer = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (pointer < i) {
                    nums[pointer] = nums[i];
                    nums[i] = 0;
                }
                pointer++;
            }
        }
    }
}
