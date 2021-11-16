package OutSide.test1;

/**

 */
public class t02 {

    public static void main(String[] args) {
        int[][] nums = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        uniquePathsWithObstacles(nums);
        t02 t = new t02();
        t.gcdOfStrings("ABCABC", "ABC");
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        return str1.substring(0, helper(str1.length(), str2.length()));
    }

    private int helper(int a, int b) {
        return b == 0 ? a : helper(b, a % b);
    }


    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }else {
                    if (i == 0 && j == 0) continue;
                    else if (i == 0) dp[i][j] = dp[i][j-1];
                    else if (j == 0) dp[i][j] = dp[i-1][j];
//                    else dp[i][j] += dp[i-1][j] + dp[i][j-1];
                    else dp[i][j] = Math.min (dp[i-1][j],dp[i][j-1]);;
                }

            }
        }
        return dp[m-1][n-1];
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) dp[i][j] += dp[i][j - 1];
                else if (j == 0) dp[i][j] += dp[i - 1][j];
                else dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}
