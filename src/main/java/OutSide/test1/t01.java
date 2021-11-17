package OutSide.test1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * [10,9,2,5,3,7,101,18]
 * [[1,3,1],[1,5,1],[4,2,1]]
 */
public class t01 {

    public static void main(String[] args) {
        int[] nums = {17,18,5,4,6,1};
        replaceElements(nums);

//        int i = coinChange(new int[]{1, 2, 5}, 11);
//        System.out.println(i);
        int change = change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }

    public static int coinChange(int[] coins, int amount) {
        // dp[i] 表示 以nums[i]结尾 需要最小的金币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // 金币是物品 金额是背包
        for (int i = 0; i <= amount; i++) {
            for (int coin:coins){
                if (i - coin >= 0){
                    dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    public static int change(int amount, int[] coins) {
        // 这里是零钱兑换的 组合类型

        // dp[i] 金额为i时有多少种组合

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i] >= 0){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }



    public int mySqrt(int x) {
        int min = 0, max = x;
        while (max - min > 1){
            int m = min + (max - min) / 2;
            if (m > x / m) max = m;
            else min = m;
        }
        return min;
    }

    public static int[] replaceElements(int[] arr) {
        // dp[i] 表示以arr[i] 向右边看的最大的数字 18,6,6,6,1,-1
        int[] dp = new int[arr.length];
        dp[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--){
            dp[i] = Math.max(dp[i + 1], arr[i + 1]);
        }
        return dp;
    }


    public static int minPathSum2(int[][] grid) {
        // 总和最小的
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m-1][n-1];
    }


    public static int minPathSum(int[][] grid) {
        // 总和最小的
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) dp[i][j] += grid[i][j - 1];
                else if (j == 0) dp[i][j] += grid[i - 1][j];
                else dp[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return dp[m-1][n-1];
    }

    public static int lengthOfLIS(int[] nums) {
        // 最长递增子序列
        // dp[i] 表示以nums[i]结尾的最长..

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 必须使用dump节点，避免头节点处理的不一致
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode cur = dump, fast = dump, slow = dump;
        while (n-- > 0) {
            fast = fast.next;
        }
        fast = fast.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dump.next;
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) continue;
                    else if (i == 0) dp[i][j] = dp[i][j - 1];
                    else if (j == 0) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public int uniquePaths(int m, int n) {
        // 总共有多少条不同的路径
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) dp[i][j] = dp[i][j - 1];
                else if (j == 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + +2) / 2;
        return (helper(nums1, 0, nums2, 0, left) + helper(nums1, 0, nums2, 0, right)) / 2.0;
    }

    private double helper(int[] nums1, int i, int[] nums2, int j, int size) {
        // gap是size / 2

        // 特例
        if (i >= nums1.length) return nums2[j + size - 1];
        if (j >= nums2.length) return nums1[i + size - 1];
        if (size == 1) return Math.min(nums1[i], nums2[j]);

        int gap = size / 2;
//        int val1 = i + gap - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[i + gap - 1];
//        int val2 = j + gap - 1 >= nums2.length ? Integer.MAX_VALUE : nums1[j + gap - 1];
        int val1 = i + gap - 1 < nums1.length ? nums1[i + gap - 1] : Integer.MAX_VALUE;
        int val2 = j + gap - 1 < nums2.length ? nums2[j + gap - 1] : Integer.MAX_VALUE;
        if (val1 < val2) {
            return helper(nums1, i + gap, nums2, j, size - gap);
        } else {
            return helper(nums1, i, nums2, j + gap, size - gap);
        }
    }


    public static String removeDuplicates(String s, int k) {
        // 两个栈来实现
        Deque<Character> strs = new LinkedList<>();
        Deque<Integer> times = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (strs.isEmpty() || strs.peek() != c) {
                strs.push(c);
                ;
                times.push(1);
            } else if (strs.peek() == c) {
                Integer val = times.pop();
                times.push(val + 1);
            }

            // 查看次数 检查出栈
            if (!times.isEmpty() && times.peek() == k) {
                times.pop();
                strs.pop();
            }
        }

        StringBuilder path = new StringBuilder();

        // 最终结果
        int size = strs.size();
        for (int i = 0; i < size; i++) {
            int val = times.pop();
            char c = strs.pop();
            for (int j = 0; j < val; j++) {
                path.append(c);
            }
        }

        return path.reverse().toString();
    }
}
