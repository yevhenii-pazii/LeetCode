package problem.p0100_0199;

class P121 {

    public static void main(String[] args) {
        System.out.println(new P121().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new P121().maxProfit(new int[]{7,6,5}));
    }

    public int maxProfit(int[] prices) {
        var maxProfit = 0;
        var min = prices[0];

        for (var i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }
}
