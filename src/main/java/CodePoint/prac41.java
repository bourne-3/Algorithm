package CodePoint;

/**
 * 连续子数组的最大和
 *
 *
 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

 要求时间复杂度为O(n)。
 */
public class prac41 {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        // 确定dp定义 以及 递推公式
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
