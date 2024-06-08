package problem.p0500_0599;

import java.util.HashMap;
import java.util.Map;

class P523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        return false;
    }

    /*
        Time Complexity O(N ^ 2) Time limit
        Space Complexity O(1)
     */
    public boolean checkSubarraySumV1(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int prefix = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                prefix += nums[j];
                if (prefix % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    /*  Not mine, but need to remember
        Time Complexity O(N) 88.17%
        Space Complexity O(N) 69.25%
     */
    public boolean checkSubarraySumModPrefix(int[] nums, int k) {
        Map<Integer, Integer> mods = new HashMap<>(); // mod, index
        mods.put(0, -1);
        int prefixMod = 0;
        for (int i = 0; i < nums.length; i++) {
            int newMode = (prefixMod + nums[i]) % k;

            if (mods.containsKey(newMode)) {
                if (i - mods.get(newMode) > 1) {
                    return true;
                }
            } else {
                mods.put(newMode, i);
            }
            prefixMod = newMode;
        }

        return false;
    }

}
