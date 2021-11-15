package CodeTop.Tencent;

/**

 */
public class prac9 {

    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        String s1 = "";
        String s2 = "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = extend(s, i, i);
            res = res.length() > s1.length() ? res : s1;
            s2 = extend(s, i, i+1);
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String extend(String s, int start, int end) {
        String tmp = "";
        while (start >= 0 && end < s.length()) {
            tmp = tmp.substring(start, end + 1); // 左闭右开，因此需要+1‘
        }
        return tmp;
    }
}
