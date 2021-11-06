package OutSide.test1;

/**

 */
public class t03 {

    public static void main(String[] args) {
        t03 t = new t03();
        int res = t.T(3);
        System.out.println(res);
        int a, b;
    }

    public int T(int n) {
        if (n == 1) return 1;

        return n + T(n-1);
    }

    public int strToInt(String str) {
        char[] chs = str.trim().toCharArray();
        int sign = 1;
        int res = 0;
        int k = 1;
        int boundary = Integer.MAX_VALUE / 10;
        if (chs[0] == '-') sign = -1;
        else if (chs[0] != '+') k = 0;
        for (int i = k; i < chs.length; i++){
            if (chs[i] < '0' || chs[i] > '9') break;
            if (res > boundary || res == boundary && chs[i] > '7'){
                return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res * 10 + (chs[i] - '0');
        }
        return sign * res;
    }
}
