package problem.p1200_1299;

class P1295 {
    public int findNumbers(int[] nums) {
        var count = 0;
        for (var num : nums) {
            if (String.valueOf(num).length() % 2 == 0) count++;
        }

        return count;
    }
}
