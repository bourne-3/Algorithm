package OutSide.test1;

import java.util.*;

/**

 */
public class t07 {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 为了保证连续，因此判断的需要是dp，而不是n
            if (dp[i - 1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        // 遍历所有字符串
        for (String s:strs){
            char[] chs = s.toCharArray();
            // 对chs进行排序，目的是为了让所有异位词都变成一样
            Arrays.sort(chs);

            String tmpStr = new String(chs);
            if (!map.containsKey(tmpStr)) {
                map.put(tmpStr, new ArrayList<>());
            }
            map.get(tmpStr).add(s);
        }

        // 添加结果
        return new ArrayList<>(map.values());
    }
}
