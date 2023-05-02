package problem;

public class P189 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public void rotateAdditionalArray(int[] nums, int k) {
        k = k % nums.length;

        var temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);

        for (var i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = temp[i];
        }
    }

    /*
        Time Complexity O(N * K)
        Space Complexity O(1)
     */
    public void rotateKRotations(int[] nums, int k) {
        k = k % nums.length;

        for (var i = 0; i < k; i++) {
            var temp = nums[nums.length - 1];

            for (var j = nums.length - 2; j >= 0 ; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)

        Moving to the next index till all moved
     */
    public void rotateFlow(int[] nums, int k) {
        k = k % nums.length;

        var rotation = 0;
        var beginningIndex = 0;
        while (rotation < nums.length) {
            var currentIndex = beginningIndex;
            var previous = nums[currentIndex];
            var temp = 0;
            do {
                var nextIndex = (currentIndex + k) % nums.length;
                temp = nums[nextIndex];
                nums[nextIndex] = previous;
                previous = temp;

                currentIndex = nextIndex;
                rotation++;
            } while (currentIndex != beginningIndex);
            beginningIndex++;
        }
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)

        Moving to the next index till all moved
     */
    public void rotateReverse(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);


    }
    private void reverse(int[] nums, int beginning, int end) {
        while (beginning < end) {
            var temp = nums[beginning];
            nums[beginning] = nums[end];
            nums[end] = temp;
            beginning++;
            end--;
        }
    }

}
