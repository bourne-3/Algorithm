package OutSide.test1;

import java.util.HashMap;

/**

 */
public class tt5 {

    public static void main(String[] args) {
        T1(new int[]{1,2,1,2,5});
    }

    public static void T1(int[] nums){
        int x = 0;
        for (int n:nums){
            x ^= n;
        }
        System.out.println(x);
    }
}
