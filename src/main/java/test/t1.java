package test;

import java.util.Random;

/**
 用你熟悉的语言实现生成随机字符串的函数gen_random_str()。参数输入为预期的字符串长度，是否需要特殊字符。
 特殊字符参考：_+-&=!@#$%^*
 样例：gen_random_str(length=10, need_special_character=True)
        数字 英文字母()
 输出结果：

 gen_random_str(12, True),   执行参考结果：#g76UD#mbs73

 gen_random_str(8, False),    执行参考结果：DOutICKL


 */
public class t1 {

    public static void main(String[] args) {
        // 生成随机字符串  腾讯云  经营的系统  php  go
        String res1 = gen_random_str(12, true);
        String res2 = gen_random_str(8, false);

        System.out.println(res1 + " : 长度为：" + res1.length());
        System.out.println(res2 + " : 长度为：" + res2.length());
    }
    static String gen_random_str(int length, boolean need_special_character){
        String in = "abcdefghijklomopqrstuvwxyzABCDEFGHIJKLMOPQRSTUVWXYZ123456789";  // 60
        String special = "_+-&=!@#$%^*";  // 12
        StringBuilder path = new StringBuilder();
        Random random = new Random();
//        if (need_special_character){
//            in = in + special;
//            for (int i = 0; i < length; i++) {
//                int num = random.nextInt(in.length());
//                path.append(in.charAt(num));
//            }
//        }else {
//            for (int i = 0; i < length; i++) {
//                int num = random.nextInt(in.length());
//                path.append(in.charAt(num));
//            }
//        }

        in = need_special_character == true ? in + special : in;
        for (int i = 0; i < length; i++) {
                int num = random.nextInt(in.length());
                path.append(in.charAt(num));
        }


        return path.toString();
    }

    public void helper() {

    }
}
