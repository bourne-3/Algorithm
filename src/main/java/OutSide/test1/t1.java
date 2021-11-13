package OutSide.test1;

import java.util.HashSet;

/**

 */
public class t1 {

    public static void main(String[] args) {

    }

    public int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n:nums){
            if (!set.add(n))return n;
        }
        return -1;
    }
}
