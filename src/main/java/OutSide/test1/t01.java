package OutSide.test1;

import java.util.Arrays;

/**

 */
public class t01 {

    public static void main(String[] args) {
        lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    public void heapSort(int[] nums){

        int size = nums.length;
        // 第一个非叶子节点
        for (int i = size * 2 - 1; i >= 0; i--){
            adjust(nums, i, size);
        }

        for (int i = size - 1; i >= 1; i--){
            swap(nums, 0, i);
            adjust(nums, 0, i);
        }
    }

    private void adjust(int[] nums, int vertexIdx, int size) {
        int left = 2 * vertexIdx + 1;
        int right = 2 * vertexIdx + 2;
        int maxIdx = vertexIdx;
        if (left < size && nums[left] > nums[maxIdx]) maxIdx = left;
        if (right < size && nums[right] > nums[maxIdx]) maxIdx = right;
        if (maxIdx != vertexIdx){
            swap(nums, maxIdx, vertexIdx);
            adjust(nums, maxIdx, size);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    // 字符串相乘
    public String multiply(String num1, String num2) {
        int m = num1.length()-1;
        int n = num2.length()-1;
        int[] mul = new int[m + n + 2];
        for (int i = m; i >= 0; i--){
            for (int j = n; j >= 0; j--){
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // 加上之前的
                tmp += mul[i + j + 1];

                mul[i + j] += tmp / 10;
                mul[i + j + 1] = tmp % 10;
            }
        }

        int count = 0;
        while (count < mul.length - 1 && mul[count] == 0) count++;

        StringBuffer path = new StringBuffer();
        for (int i =count; i < mul.length; i++) {
            path.append(mul[i]);
        }
        return path.toString();
    }


    // 字符串数字转换为整数
    public int myAtoi(String s) {
        s = s.trim();
        char[] chs = s.toCharArray();
        if (chs.length == 0) return 0;
        int sign = 1, res = 0, boundary = Integer.MAX_VALUE / 10, cur = 1;
        if (chs[0] == '-') sign = -1;
        else if (chs[0] != '+') cur = 0;
        for (int i = cur; i < chs.length; i++){
            char c = chs[i];
            if (c < '0' || c > '9') break;
            if (res > boundary || res == boundary && c > '7') {
                return sign == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res * 10 + (c - '0');
        }
        return res * sign;
    }

    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();  // 49
            if (num <= 40) return num;
            num = (num - 40 - 1) * 7 + rand7();  // 63
            if (num <= 60) return num;
            num = (num - 60 - 1) * 7 + rand7(); // 21
            if (num <= 20) return num;
        }
    }

    public int rand7() {
        return -1;
    }

    // 最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
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
            res = s1.length() > res.length() ? s1 : res;
            s2 = extend(s, i, i + 1);
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;

    }

    private String extend(String s, int i, int j) {
        String path = "";
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            path = s.substring(i, j + 1);
            i--;
            j++;
        }
        return path;
    }
}
