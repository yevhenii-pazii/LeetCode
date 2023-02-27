public class P70 {

    public static void main(String[] args) {
        System.out.println(new P70().climbStairs(7));
        System.out.println(new P70().climbStairsFlat(7));
    }

    public int climbStairs(int n) {
        if (n < 2) return n;
        var combinations = new int[n];
        combinations[0] = 1;
        combinations[1] = 2;

        for (int i = 2; i < n; i++) {
            combinations[i] = combinations[i - 1] + combinations[i - 2];
        }

        return combinations[n-1];
    }

    public int climbStairsFlat(int n) {
        if (n < 2) return n;
        int previous = 1, current = 2, temp;
        for (; n > 2; n--) {
            temp = current;
            current = current + previous;
            previous = temp;
        }

        return current;
    }
}
