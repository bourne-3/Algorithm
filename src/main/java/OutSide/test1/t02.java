package OutSide.test1;

import java.util.HashSet;

/**

 */
public class t02 {

    public static void main(String[] args) {
//        int[] nums = {0,0,1,2,5};
//        isStraight(nums);

        int i = bitSum(21);
        System.out.println(i);
    }

    public static boolean isStraight(int[] nums) {
        // 不重复 ||  max - min > 5
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n:nums){
            if (n == 0) continue;
            if (set.contains(n)) return false;
            set.add(n);
            if (n > max) max = n;
            if (n < min) min = n;
        }
        return max - min < 5;
    }

    static int bitSum(int num){
        int res = 0;
        while (num > 0){
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
