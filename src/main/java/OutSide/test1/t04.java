package OutSide.test1;

import org.omg.PortableInterceptor.INACTIVE;

/**
 题目要求返回的数值范围应在
因此需要考虑数字越界问题。而由于题目指出 环境只能存储 32 位大小的有符号整数 ，
 因此判断数字越界时，要始终保持 res 在 int 类型的取值范围内。

2147483647

 */
public class t04 {

    public static void main(String[] args) {
//        int i = myAtoi("  -42");
        int i = myAtoi2("-2147483647");
        System.out.println(i);
//        System.out.println(Integer.MIN_VALUE);
    }

    public static int myAtoi(String s) {
        s = s.trim();
        char[] chs = s.toCharArray();
        if (chs.length == 0) return 0;
        int res = 0, sign = 1, boundary = Integer.MAX_VALUE / 10, cur = 1;
        // 边界判断
        if (chs[0] == '-') sign = -1;
        else if (chs[0] != '+') cur = 0;

        // 开始循环
        for (int i = cur; i < chs.length; i++) {
            char c = chs[i];
            if (c < '0' || c > '9') break;
            if (res > boundary || res == boundary && c > '7'){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c - '0');
        }
        return sign * res;
    }

    public static int myAtoi2(String s) {
        s = s.trim();
        char[] chs = s.toCharArray();
        if (chs.length == 0) return 0;
        int sign = 1, res = 0, boundary = Integer.MAX_VALUE / 10, cur = 1;
        if (chs[0] == '-') sign = -1;
        else if (chs[0] != '+') cur = 0;

        for (int i = cur; i < chs.length; i++){
            if (chs[i] > '9' || chs[i] < '0') break;
            if (res > boundary || res == boundary && chs[i] > '7'){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chs[i] - '0');
        }
        return sign * res;
    }













    public int strToInt(String str) {
        str = str.trim();
        char[] chs = str.toCharArray();
        if (chs.length == 0) return 0;

        int sign = 1, boundary = Integer.MAX_VALUE / 10, cur = 1 , res = 0;
        // 由于已经裁剪了 现在已经没有空格
        if (chs[0] == '-') sign = -1;
        else if (chs[0] != '+') cur = 0;
        for (int i = cur; i < chs.length; i++) {
            if (chs[i] < '0' || chs[i] > '9') break;
            if (res > boundary || res == boundary && chs[i] > '7'){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chs[i] - '0');
        }
        return sign * res;
    }
}
