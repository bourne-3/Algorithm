package CodePoint;

import java.util.HashMap;
import java.util.HashSet;

/**
 最长无重复字符串
 */
public class prac20 {

    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = "bbbbb";
        lengthOfLongestSubstring(s);
    }

    public static void lengthOfLongestSubstring(String s) {
        // 需要的容器
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        // 记录最终的结果
        int res = 0;

        // 左边指针，从该指针开始均为无重复的字符
        int leftPoint = 0;
        for (int i = 0; i < chs.length; i++){
            char c = chs[i];
            // 如果字符串中已经有该字符了，并且大于或等于leftPoint。需要替换leftPoint的位置。
            // 等于也要处理，因为会重复
            if (map.containsKey(c) && map.get(c) >= leftPoint){
                leftPoint = map.get(c) + 1;
            }
            map.put(c, i);
            // 每次都取最大，这个跟打家劫舍的思路一致
            res = Math.max(res, i - leftPoint + 1);
        }
        System.out.println("最长无重复的长度为：" + res);


    }
}
