package OutSide.test1;

/**

 */
public class t04 {

    public static void main(String[] args) {

    }









    public String longestPalindrome(String s) {
        String s1 = "";
        String s2 = "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = extend(s, i, i);
            res = s1.length() > res.length() ? s1 : res;
            s2 = extend(s, i, i + 1);
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    public String extend(String s, int start, int end){
        String tmp = "";
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            tmp = s.substring(start, end + 1);
            start--;
            end++;
        }
        return tmp;
    }
}
