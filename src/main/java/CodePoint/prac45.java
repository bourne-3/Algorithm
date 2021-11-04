package CodePoint;

import java.util.HashMap;
import java.util.HashSet;

/**
 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class prac45 {

    public static void main(String[] args) {
        char flag = firstUniqChar2("leetcode");
        System.out.println(flag);
    }

    public static char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];

            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        char flag = ' ';
        for (char c : map.keySet()){
            // 我知道这里为什么错了，因为keySet出来的是无序的。如果是从chs取出来就可以了
            Integer count = map.get(c);
            if (count == 1) {
                flag = c;
                break;
            }
        }
        return flag;

    }

    public static char firstUniqChar2(String s) {
        // 思路：使用hashMap，key是字符，value为是否是重复的
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c: charArray){
            map.put(c, map.containsKey(c));
        }

        for (char c: charArray){
            if(!map.get(c)) return c;
        }
        return ' ';

    }
}
