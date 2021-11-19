package OutSide.test1;

import java.util.Arrays;

/**

 */
public class t01 {

    public static void main(String[] args) {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }

    // 最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {

    }

    // 最长递增子序列
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 最长回文串
    public String longestPalindrome(String s) {
        String s1 = "";
        String s2 = "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = extend(s, i, i);
            res = s1.length() > res.length() ? s1:res;
            s2 = extend(s, i, i + 1);
            res = s2.length() > res.length() ? s2:res;
        }
        return res;

    }

    private String extend(String s, int i, int j) {
        String path = "";
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            path = s.substring(i ,j + 1);
            i--;
            j++;
        }
        return path;
    }
}
