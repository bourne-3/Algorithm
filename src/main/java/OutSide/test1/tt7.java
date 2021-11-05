package OutSide.test1;

/**

 */
public class tt7 {

    public static void main(String[] args) {
//        StringBuilder t = new StringBuilder("test");
//        temporalReverse(t, 1, 3);
//        System.out.println(t.toString());

        String res = reverseLeftWords("abcdefg", 2);
        System.out.println(res);
    }

    public static String reverseLeftWords(String s, int n) {
        StringBuilder tmp = new StringBuilder(s);
        temporalReverse(tmp, 0, n - 1);
        temporalReverse(tmp, n, s.length() - 1);
        tmp.reverse();
        return tmp.toString();
    }

    private static void temporalReverse(StringBuilder tmp, int start, int end) {
        while (start < end){
            char chStart = tmp.charAt(start);
            char chEnd = tmp.charAt(end);
            tmp.setCharAt(end, chStart);
            tmp.setCharAt(start, chEnd);
            start++;
            end--;
        }
    }
}
