public class P485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0, max = 0;
        for(var num : nums) {
            current = num == 1? current + 1 : 0;
            max = Math.max(current, max);
        }
        return max;
    }
}