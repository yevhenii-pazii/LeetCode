package problem.p0000_0099;

class P75 {

    public void sortColors(int[] nums) {

    }

    /*
        Time Complexity O(N) 100%
        Space Complexity O(1) 97.2%
     */
    public void sortColorsInPlace(int[] nums) {
        int i0 = -1;
        int i2 = nums.length;

        while (i0 < nums.length - 1 && nums[i0 + 1] == 0) {
            i0++;
        }

        while (i2 > 0 && nums[i2 - 1] == 2) {
            i2--;
        }

        int i1 = i0 + 1;
        while (i1 < i2) {
            if (nums[i1] == 0) {
                nums[i1] = nums[++i0];
                nums[i0] = 0;
                if (i0 == i1) {
                    i1++;
                }
            } else if (nums[i1] == 1) {
                i1++;
            } else {
                nums[i1] = nums[--i2];
                nums[i2] = 2;
            }
        }
    }


    /*
        Time Complexity O(N) 100%
        Space Complexity O(1) 88.84%
     */
    public void sortColorsCounting(int[] nums) {
        int[] counts = new int[3]; //only 0, 1, and 2
        for (var num : nums) {
            counts[num]++;
        }

        for (int i = 0, ci = 0; i < nums.length; i++) {
            while(ci < counts.length && counts[ci] == 0) {
                ci++;
            }
            nums[i] = ci;
            counts[ci]--;
        }
    }

}
