package CodeTop.Tencent;

/**
字符串相乘

 放在和字符串转为数字一起记忆

 // 这道题靠着自己一步一步debug 给de出来了
 */
public class prac25 {

    public static void main(String[] args) {
        String res = multiply("300", "400");
        System.out.println(res);
    }

    public static String multiply(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int[] mul = new int[m + n + 2];

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 加上原有的
                tmp += mul[i + j + 1];

                // 左边
                mul[i + j] += tmp / 10;

                // 右边被替换
                mul[i + j + 1] = tmp % 10;
            }
        }

        // 需要剩下一个
        int count = 0;
        while (mul[count] == 0 && count < mul.length - 1) count++;

        StringBuilder path = new StringBuilder();
        for (int i = count; i < mul.length; i++) {
            path.append(mul[i]);
        }
        return path.toString();
    }
}
