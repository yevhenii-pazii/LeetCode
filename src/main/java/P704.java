public class P704 {

    public static void main(String[] args) {
        System.out.println(new P704().search(new int[]{-1,0,3,5,9,12}, 9));
    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (end >= start) {
            var middle = (end - start) / 2 + start;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] > target) {
                end = middle - 1;
            } else  {
                start = middle + 1;
            }
        }

        return -1;
    }


}
