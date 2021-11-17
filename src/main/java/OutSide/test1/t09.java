package OutSide.test1;

/**

 */
public class t09 {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        targetSum -= root.val;
        if (root.left == null && root.right == null) return targetSum == 0;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        // dp[i][j] 表示字符串 s1[0..i-1]  s2[0..j-1]中的最长公共字串

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] += dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j]);
                }
            }
        }
        return dp[l1-1][l2-1];
    }

    public int maxProfit(int[] prices) {
        int cost = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            cost = Math.min(cost, prices[i]);
            profit = Math.max(profit, prices[i] - cost);
        }
        return profit;
    }

    public int findMin(int[] nums) {
        // 使用二分法的思路
        int l = 0, r = nums.length - 1;
        while (l < r){
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) r = m;
            else if (nums[m] > nums[r]) l = m + 1;
            else return findRes(nums, l, r);
        }
        return nums[l];
    }

    private int findRes(int[] nums, int l, int r) {
        int res = nums[l];
        for (int i = 0; i <= r; i++) {
            if (nums[i] < res) res = nums[i];
        }
        return res;
    }
}
