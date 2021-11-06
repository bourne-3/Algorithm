package OutSide.test1;

import java.util.HashMap;

/**

 */
public class t04 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (map.containsKey(c) && map.get(c) >= left){
                left = map.get(c) + 1;
            }
            map.put(c, i);
            res = Math.max(res, left - i  + 1);
        }
        return res;



    }
}
