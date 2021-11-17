package CodeTop.Tencent;

/**
 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class prac22 {

    public static void main(String[] args) {
        int res = findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println(res);
    }

    public static int findDuplicate(int[] nums) {
        // 环形链表的思路
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
