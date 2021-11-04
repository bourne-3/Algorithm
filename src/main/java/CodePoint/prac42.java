package CodePoint;

/**
 把数字翻译成字符串
 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11
 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法

 */
public class prac42 {

    public static void main(String[] args) {
        int res = translateNum(12258);
        System.out.println(res);
    }

    public static int translateNum(int nums) {
        String s = String.valueOf(nums);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++){
            String sub = s.substring(i - 2, i);
            if (sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
