package OutSide.test1;

import java.util.*;

/**

 */
public class t07 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> Integer.compare(o1[0], o2[0])));
        int start = intervals[0][0];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length ; i++) {
            if (intervals[i][0] > intervals[i-1][1]){
                // 添加
                res.add(new int[]{start, intervals[i-1][1]});
                start = intervals[i][0];
            }else {
                // 因为这里的i会变成下一次的i-1
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }
        }
        // 收尾
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        int[][] out = res.toArray(new int[res.size() - 1][]);
        return out;
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
