package OutSide.test1;

import java.util.HashMap;
import java.util.Map;

/**

 */
public class t06 {

    public static void main(String[] args) {
        t06 t = new t06();
        int res = t.lengthOfLongestSubstring("abcabcbb");

    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        int res = 0, left = 0;
        for (int i = 0; i < chs.length; i++){
            char c = chs[i];
            if (map.containsKey(c) && map.get(c) >= left) left = map.get(c) + 1;
            map.put(c, i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
