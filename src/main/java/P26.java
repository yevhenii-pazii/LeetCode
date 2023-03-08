import java.util.Arrays;

public class P26 {

    public static void main(String[] args) {
        var arr = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(new P26().removeDuplicates(arr) + " " + Arrays.toString(arr));
        System.out.println(new P26().removeDuplicatesV2(arr) + " " + Arrays.toString(arr));
    }

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


/* better from discussion
    public int removeDuplicates(int[] nums) {
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

*/
}