package CodePoint;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;

/**
 统计一个数字在排序数组中出现的次数。
 */
public class prac48 {

    public static void main(String[] args) {
        int res = search(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        // 这不是使用一个HashMap就可以解决了吗

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val)){
                map.put(val, map.get(val) + 1);
            }else {
                map.put(val, 1);
            }
        }
        return map.get(target);
    }
}
