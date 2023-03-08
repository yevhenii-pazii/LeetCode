import java.util.Arrays;

public class P905 {

    public static void main(String[] args) {
        var arr = new int[]{3, 1, 2, 4};
        System.out.println(Arrays.toString(new P905().sortArrayByParity(arr)));

        System.out.println(Arrays.toString(new P905().sortArrayByParity(new int[]{0})));
        System.out.println(Arrays.toString(new P905().sortArrayByParity(new int[]{2,4})));
        System.out.println(Arrays.toString(new P905().sortArrayByParity(new int[]{1,3})));
    }

    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length < 2) return nums;

        var evenPointer = nums.length - 1;
        var oddPointer = 0;
        while (oddPointer < evenPointer) {
            if (nums[oddPointer] % 2 == 0) {
                oddPointer++;
                continue;
            }
            if (nums[evenPointer] % 2 != 0) {
                evenPointer--;
                continue;
            }

            int temp = nums[evenPointer];
            nums[evenPointer] = nums[oddPointer];
            nums[oddPointer] = temp;
            oddPointer++;
            evenPointer--;

        }

        return nums;
    }

    // From Discussions
    public int[] sortArrayByParityNotMine(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }
}
