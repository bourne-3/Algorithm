package OutSide.test1;

import java.util.HashMap;

/**
 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class t02 {

    public static void main(String[] args) {

    }

    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for (char c:chs){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
                continue;
            }

            map.put(c, 1);
        }

        for (char c:chs){
            int val = map.get(c);
            if (val == 1) return c;
        }
        return ' ';
    }
}
