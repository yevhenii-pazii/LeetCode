package problem;

public class P485 {

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0, max = 0;
        for(var num : nums) {
            current = num == 1? current + 1 : 0;
            max = Math.max(current, max);
        }
        return max;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)

        This one is faster previous one as Math.max executed only on 0ths
     */
    public int findMaxConsecutiveOnesImproved(int[] nums) {
        var current = 0;
        var max = 0;

        for (var num : nums) {
            if (num == 0) {
                max = Math.max(max, current);
                current = 0;
            } else {
                current++;
            }

        }
        return Math.max(current, max);
    }
}