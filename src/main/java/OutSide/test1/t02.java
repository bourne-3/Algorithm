package OutSide.test1;

/**

 */
public class t02 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // 每次都记录最大值
        int max = nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = dp[i-1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
