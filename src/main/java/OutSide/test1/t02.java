package OutSide.test1;

import java.util.HashMap;
import java.util.HashSet;

/**

 */
public class t02 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        // 做过，好像使用一个left来定位
        int left = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (map.containsKey(c) && map.get(c) >= left){
                left = map.get(c) + 1;
            }

            map.put(c, i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
