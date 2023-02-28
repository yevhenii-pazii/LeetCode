public class P746 {

    public static void main(String[] args) {
        System.out.println("-> " + new P746().minCostClimbingStairs2(new int[]{1, 15, 1, 3}));
        System.out.println("must be 15 -> " + new P746().minCostClimbingStairs2(new int[]{10, 15, 20}));

        System.out.println("must be 6 -> " + new P746().minCostClimbingStairs2(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 100}));
    }

    /*
    My, recursive, but really slow.
     */
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(min(cost, 0), min(cost, 1));
    }

    private int min(int[] cost, int index) {
        if (index >= cost.length) return 0;
        if (index == cost.length - 1) return cost[cost.length - 1];

        return cost[index] + Math.min(min(cost, index + 1), min(cost, index + 2));
    }

    /*
    Not my, but improved by me
     */
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }

    /*
    Doesn't work - my solution
     */
    public int minCostClimbingStairs1(int[] cost) {
        int minCost = 0;

        int i = 0;
        while (i < cost.length) {
            int n1 = cost[i], n2 = 0, n3 = 0, n4 = 0;

            if (i + 1 < cost.length) {
                n2 = cost[i + 1];
            }
            if (i + 2 < cost.length) {
                n3 = cost[i + 2];
            }
            if (i + 3 < cost.length) {
                n4 = cost[i + 3];
            }

            if (n1 + n3 < n2 + Math.min(n3, n4)) {
                i++;
                minCost += n1;
            } else {
                i += 2;
                minCost += n2;
            }
        }

        return minCost;
    }
}
