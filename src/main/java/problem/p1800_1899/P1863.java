package problem.p1800_1899;

class P1863 {

    public int subsetXORSum(int[] nums) {
        return 0;
    }

    /*
        Doesn't work
     */
    public int subsetXORSumImpl1(int[] nums) {
        int result = 0;

        for (var i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            result += nums[i];

            for (var j = i + 1; j < nums.length; j++) {
                result += nums[i] ^ nums[j];

                System.out.println(nums[i] + " ^ " + nums[j]);
            }
        }

        return result;
    }

    /*
        Doesn't work
    */
    public int subsetXORSumImpl2(int[] nums) {
        int result = 0;

        for (var l = 1; l <= nums.length; l++) {
            int[] indexes = new int[l];
            for (int i = 0; i < indexes.length; i++) {
                indexes[i] = i;
            }

            boolean end = false;
            MAIN:
            do { // need to think
                int subResult = 0;

                for (int p1 = 0; p1 < indexes.length - 1; p1++) {
                    subResult = subResult ^ nums[indexes[p1]];
                }

                var index = indexes.length - 1;
                for (; indexes[index] < nums.length; indexes[index]++) {
                    result = result + subResult ^ nums[indexes[index]];
                }

                // increment
                for (int i = indexes.length - 1; i >= 0; i--) {

                }
                end = true;
            } while (end);

        }

        return result;
    }

    /*
        Time Complexity O(2^N) 100%
        Space Complexity O(N) 82.48%

        Implemented when seen tree and read logic with adding and not
     */
    public int subsetXORSumBacktracking(int[] nums) {
        return xorHelper(nums, 0, 0);
    }

    private static int xorHelper(int[] nums, int index, int subResult) {
        if (index == nums.length) {
            return subResult;
        }

        int with = xorHelper(nums, index + 1, subResult ^ nums[index]);
        int without = xorHelper(nums, index + 1, subResult);

        return with + without;
    }

}
