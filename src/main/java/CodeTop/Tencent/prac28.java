package CodeTop.Tencent;

/**
 字符串转换整数 (atoi)
 */
public class prac28 {

    public static void main(String[] args) {
        int res = myAtoi("   -42");
        System.out.println(res);
    }

    public static int myAtoi(String s) {
        s = s.trim();
        int res = 0, sign = 1, cur = 1, boundary = Integer.MAX_VALUE / 10;

        char[] chs = s.toCharArray();
        if (chs.length == 0) return 0;
        if (chs[0] == '-') sign = -1;
        else if (chs[0] != '+') cur = 0;

        for (int i = cur; i < chs.length; i++) {
            if (chs[i] < '0' || chs[i] >'9') break;
            if (res > boundary || res == boundary && chs[i] >'7'){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (chs[i] - '0');
        }
        return sign * res;
    }
}
