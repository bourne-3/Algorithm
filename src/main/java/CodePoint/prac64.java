package CodePoint;

/**
 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class prac64 {

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};

        int res = maxProfit(nums);
        System.out.println(res);
    }

    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;

        // 成本
        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 记录最小的成本
            cost = Math.min(cost, prices[i]);
            dp[i] = Math.max(dp[i-1], prices[i] - cost);
        }
        return dp[prices.length - 1];
    }
}
