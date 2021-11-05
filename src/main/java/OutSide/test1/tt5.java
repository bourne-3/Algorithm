package OutSide.test1;

import java.util.HashMap;

/**

 */
public class tt5 {

    public static void main(String[] args) {
        T1(new int[]{1,2,1,2,5});

        // 0和任何数异或都等于本省
        System.out.println(0 ^ 10);
        System.out.println(3^3); // 同0 异1

        System.out.println(3 & 1);
    }

    public static void T1(int[] nums){
        int x = 0;
        for (int n:nums){
            x ^= n;
        }
        System.out.println(x);
    }
}
