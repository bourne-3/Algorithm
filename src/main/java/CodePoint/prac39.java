package CodePoint;

import java.util.Arrays;
import java.util.HashMap;

/**
 数组中出现次数超过一半的数字

 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class prac39 {

    public static void main(String[] args) {
        int res = majorityElement2(new int[]{6, 5, 5});
        System.out.println(res);
    }

    public static int majorityElement2(int[] nums) {
        // 使用HashMap的方法
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n:nums){
            if (map.containsKey(n)){
                map.put(n, map.get(n) + 1);
                continue;
            }
            map.put(n, 1);
        }
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int n:nums){
            if (map.get(n) > max){
                res = n;
                max = map.get(n);
            }
        }
        return res;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[(0 + nums.length) / 2];
    }
}
