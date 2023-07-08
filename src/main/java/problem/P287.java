package problem;

import java.util.HashSet;
import java.util.Set;

public class P287 {

    /*
        Bruteforce

        Time Complexity O(N*N)
        Space Complexity O(1)
     */
    public int findDuplicate(int[] nums) {
        for (var i = 0; i < nums.length - 1; i++) {
            for (var j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return 0;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int findDuplicateCounting(int[] nums) {
        boolean[] visited = new boolean[nums.length];

        for (int num : nums) {
            if (visited[num]) {
                return num;
            } else {
                visited[num] = true;
            }
        }

        return 0;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)

        But works only numbers less than 31
     */
    public int findDuplicateBits(int[] nums) {
        var visited = 0;

        for (var num : nums) {
            if ((visited >> num & 1) == 1) {
                return num;
            } else {
                visited = visited | (1 << num);
            }
        }

        return 0;
    }

    public int findDuplicateSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (var num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }

        return 0;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)

        NOT MINE

     */
    public int findDuplicateCyclicSort(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int nxt = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = nxt;
        }
        return nums[0];
    }

    //TODO there are a lot of other approaches
}
