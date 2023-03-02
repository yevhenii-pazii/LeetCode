import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P1().twoSumWithMap(new int[]{2, 7, 11, 15}, 9)));
    }

    /* MY
     Constant memory, but works well only on the large amount of data.
     Memory -> O(1) since it doesn't matter the length of array
     CPU time  -> O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        int index0, index1;

        int shift = (int) Math.pow(10, 9);
        int[] hash = new int[2 * shift];

        for (var i = 0; i < nums.length; i++) {
            hash[nums[i] + shift] = i;
        }

        for (var i = 0; i < nums.length - 1; i++) {
            index0 = i;
            int numberToFind = target - nums[i];
            index1 = hash[numberToFind + shift];

            if (index1 > 0 && index1 != index0) {
                return new int[]{index0, index1};
            }
        }
        return null;
    }

    public int[] twoSumWithMap(int[] nums, int target) {
        Map<Integer, Integer>  table = new HashMap<>(nums.length);
        for (var i = 0; i < nums.length; i++) {
            table.put(nums[i], i);
        }

        for (var i = 0; i < nums.length - 1; i++) {
            int numberToFind = target - nums[i];
            if (table.containsKey(numberToFind)) {
                int index2 = table.get(numberToFind);
                if (i != index2) {
                    return new int[] {i, index2};
                }
            }
        }

        return null;
    }
}
