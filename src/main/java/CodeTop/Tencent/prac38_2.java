package CodeTop.Tencent;

import java.util.Arrays;

/**
 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

 */
public class prac38_2 {

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        // 背包：金额  物品：金币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // 里面是物品， 那么外面就是背包
        for (int i = 0; i <= amount; i++) {
            for (int coin:coins){
                if (i - coin >= 0){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
