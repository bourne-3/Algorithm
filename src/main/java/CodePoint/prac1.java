package CodePoint;

import java.util.HashSet;

/**
    1 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。


 */
public class prac1 {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        int[] nums = {3, 4, 2, 0, 0, 1};
        for (int i : nums){
            if (set.add(i) == false) System.out.println(i);;
        }

        System.out.println(findRepeatNumber3(nums));

    }

    public int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n:nums){
            if (!set.add(n))return n;
        }
        return -1;
    }

    public static int findRepeatNumber3(int[] nums) {
        // i 不用一直加
        for (int i = 0; i < nums.length; ) {
            if (i == nums[i]) {
                i++;
                continue;  // 下标就是该值 不用换
            }

            // 结果
            if (nums[nums[i]] == nums[i]) return nums[i];  // 有重复

            // 交换
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;

        }
        return -1;

    }


}
