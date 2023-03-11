import java.util.LinkedList;
import java.util.List;

public class P448 {

    public static void main(String[] args) {
        System.out.println(new P448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(new P448().findDisappearedNumbers(new int[]{1, 1}));

        System.out.println();

        System.out.println(new P448().findDisappearedNumbersV3(new int[]{1, 1, 2, 2}));
        System.out.println(new P448().findDisappearedNumbersV3(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(new P448().findDisappearedNumbersV3(new int[]{1, 1}));
        System.out.println(new P448().findDisappearedNumbersV3(new int[]{2, 2}));

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        var appear = new boolean[nums.length + 1];

        for (var n : nums) {
            appear[n] = true;
        }

        List<Integer> result = new LinkedList<>();
        for (var i = 1; i < appear.length; i++) {
            if (!appear[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbersV2(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int temp;
        for (var i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1] && nums[i] > i) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }

            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
            result.remove(Integer.valueOf(nums[i]));
        }

        return result;
    }

    //doesn't work
    public List<Integer> findDisappearedNumbersV3(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int temp;
        int length = nums.length;
        for (var i = 0; i < nums.length; i++) {

            while (nums[i] != i + 1 && nums[i] > i && i < length) {
                if (nums[i] == nums[nums[i] - 1]) {
                    nums[i] = nums[--length];
                } else {
                    temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }

            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }

    //Clever
    public List<Integer> findDisappearedNumbersOfficial(int[] nums) {
        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }
}
