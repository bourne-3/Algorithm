package OutSide.test1;

import java.util.Arrays;

/**

 */
public class t05 {

    public static void main(String[] args) {
        t05 t = new t05();
        int[] nums = {1, 2, 5};
        int amount = 11;
        t.coinChange(nums, amount);
        t.coinChange1(nums, amount);
    }

    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }


    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.fill(dp, -2);
        for (int i = 0; i < dp.length; i++){
            for (int n:coins){
                if (i - n < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - n]);
            }
        }
        return (dp[amount] == -2) ? -1:dp[amount];
    }





    public int[] getLeastNumbers(int[] arr, int k) {
        return QuickSort(arr, 0, arr.length - 1, k);
    }

    int[] QuickSort(int[] nums, int i, int j, int k){
        int p = 0;
        if (i < j){
            p = parition(nums, i, j);
            if (p > k) QuickSort(nums, i, p - 1, k);
            if (p < k) QuickSort(nums, p + 1, j, k);
        }
        return Arrays.copyOf(nums, k);
    }

    private int parition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i < j){
            while (i < j && nums[j] >= pivot) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) i++;
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }
}
